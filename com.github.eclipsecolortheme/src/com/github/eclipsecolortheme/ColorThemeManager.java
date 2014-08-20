package com.github.eclipsecolortheme;

import static com.github.eclipsecolortheme.ColorThemeKeys.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.framework.Bundle;
import org.osgi.service.prefs.BackingStoreException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.github.eclipsecolortheme.mapper.GenericMapper;
import com.github.eclipsecolortheme.mapper.ThemePreferenceMapper;

/** Loads and applies color themes. */
public class ColorThemeManager {
    private Map<String, ColorTheme> themes;
    private Map<String, ThemePreferenceMapper> editors;

    /** Creates a new color theme manager. */
    public ColorThemeManager() {
        editors = new HashMap<String, ThemePreferenceMapper>();
        IConfigurationElement[] config = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(
                        Activator.EXTENSION_POINT_ID_MAPPER);
        try {
            for (IConfigurationElement e : config) {
                final Object o = e.createExecutableExtension("class");
                if (o instanceof ThemePreferenceMapper) {
                    String pluginId = e.getAttribute("pluginId");
                    ThemePreferenceMapper mapper = (ThemePreferenceMapper) o;
                    mapper.setPluginId(pluginId);
                    if (o instanceof GenericMapper) {
                        String xml = e.getAttribute("xml");
                        String contributorPluginId = e.getContributor()
                                .getName();
                        Bundle bundle = Platform.getBundle(contributorPluginId);
                        InputStream input = (InputStream) bundle.getResource(
                                xml).getContent();
                        ((GenericMapper) mapper).parseMappings(input);
                    }
                    editors.put(pluginId, mapper);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        themes = new HashMap<String, ColorTheme>();
        readStockThemes(themes);
        readImportedThemes(themes);
    }

    private void readStockThemes(Map<String, ColorTheme> themes) {
        IConfigurationElement[] config = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(
                        Activator.EXTENSION_POINT_ID_THEME);
        try {
            for (IConfigurationElement e : config) {
                String xml = e.getAttribute("file");
                String contributorPluginId = e.getContributor().getName();
                Bundle bundle = Platform.getBundle(contributorPluginId);
                InputStream input = (InputStream) bundle.getResource(xml)
                        .getContent();
                ParsedTheme theme = parseTheme(input, false);
                amendThemeEntries(theme.getTheme().getEntries());
                themes.put(theme.getTheme().getName(), theme.getTheme());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readImportedThemes(Map<String, ColorTheme> themes) {
        IPreferenceStore store = getPreferenceStore();

        for (int i = 1;; i++) {
            String xml = store.getString("importedColorTheme" + i);
            if (xml == null || xml.length() == 0)
                break;
            try {
                ParsedTheme theme = parseTheme(new ByteArrayInputStream(xml.getBytes("UTF-8")), false);
                amendThemeEntries(theme.getTheme().getEntries());
                themes.put(theme.getTheme().getName(), theme.getTheme());
            } catch (Exception e) {
                System.err.println("Error while parsing imported theme");
                e.printStackTrace();
            }
        }
    }

    public void clearImportedThemes() {
        IPreferenceStore store = getPreferenceStore();
        for (int i = 1; store.contains("importedColorTheme" + i); i++)
            store.setToDefault("importedColorTheme" + i);
        themes.clear();
        readStockThemes(themes);
    }

    private static IPreferenceStore getPreferenceStore() {
        return Activator.getDefault().getPreferenceStore();
    }

    /**
     * Parses theme file.
     * @param input The input for theme file.
     * @param loadSource Specify if should load original XML source.
     * @return Parsed theme
     */
    public ParsedTheme parseTheme(InputStream input, boolean loadSource)
            throws ParserConfigurationException, SAXException, IOException, TransformerException {
        ColorTheme theme = new ColorTheme();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(input);
        Element root = document.getDocumentElement();
        theme.setId(root.getAttribute("id"));
        theme.setName(root.getAttribute("name"));
        theme.setAuthor(root.getAttribute("author"));
        theme.setWebsite(root.getAttribute("website"));

        Map<String, ColorThemeSetting> entries = new HashMap<String, ColorThemeSetting>();
        NodeList entryNodes = root.getChildNodes();
        for (int i = 0; i < entryNodes.getLength(); i++) {
            Node entryNode = entryNodes.item(i);
            if (entryNode.hasAttributes()) {
                String color = entryNode.getAttributes().getNamedItem("color")
                        .getNodeValue();
                Node nodeBold = entryNode.getAttributes().getNamedItem("bold");
                Node nodeItalic = entryNode.getAttributes().getNamedItem(
                        "italic");
                Node nodeUnderline = entryNode.getAttributes().getNamedItem(
                        "underline");
                Node nodeStrikethrough = entryNode.getAttributes()
                        .getNamedItem("strikethrough");
                ColorThemeSetting setting = new ColorThemeSetting(color);
                if (nodeBold != null)
                    setting.setBoldEnabled(Boolean.parseBoolean(nodeBold
                            .getNodeValue()));
                if (nodeItalic != null)
                    setting.setItalicEnabled(Boolean.parseBoolean(nodeItalic
                            .getNodeValue()));
                if (nodeStrikethrough != null)
                    setting.setStrikethroughEnabled(Boolean
                            .parseBoolean(nodeStrikethrough.getNodeValue()));
                if (nodeUnderline != null)
                    setting.setUnderlineEnabled(Boolean
                            .parseBoolean(nodeUnderline.getNodeValue()));
                entries.put(entryNode.getNodeName(), setting);
            }
        }
        theme.setEntries(entries);

        NodeList nodeListMappingOverrides = root.getElementsByTagName("mappingOverrides");
        if (nodeListMappingOverrides.getLength() > 0) {
            Element mappingOverridesRoot = (Element) nodeListMappingOverrides.item(0);

            Map<String, Map<String, ColorThemeMapping>> mappings = new HashMap<String, Map<String, ColorThemeMapping>>();
            NodeList nodeListEclipseColorThemeMapping = mappingOverridesRoot.getChildNodes();
            for (int i = 0; i < nodeListEclipseColorThemeMapping.getLength(); ++i) {
                Node eclipseColorThemeMapping = nodeListEclipseColorThemeMapping.item(i);
                if (eclipseColorThemeMapping.hasAttributes()) {
                    String pluginId = eclipseColorThemeMapping.getAttributes().getNamedItem("plugin").getNodeValue();
                    Map<String, ColorThemeMapping> mapMappings = new HashMap<String, ColorThemeMapping>();

                    ((GenericMapper) editors.get(pluginId)).parseMappings((Element) eclipseColorThemeMapping, mapMappings);
                    mappings.put(pluginId, mapMappings);
                }
            }
            theme.setMappings(mappings);
        }

        ParsedTheme parsedTheme = new ParsedTheme(theme);
        if (loadSource) parsedTheme.setSource(documentToString(document));
        return parsedTheme;
    }

    private static void amendThemeEntries(Map<String, ColorThemeSetting> theme) {
        applyDefault(theme, METHOD, FOREGROUND);
        applyDefault(theme, FIELD, FOREGROUND);
        applyDefault(theme, LOCAL_VARIABLE, FOREGROUND);
        applyDefault(theme, JAVADOC, MULTI_LINE_COMMENT);
        applyDefault(theme, JAVADOC_LINK, JAVADOC);
        applyDefault(theme, JAVADOC_TAG, JAVADOC);
        applyDefault(theme, JAVADOC_KEYWORD, JAVADOC);
        applyDefault(theme, OCCURRENCE_INDICATION, BACKGROUND);
        applyDefault(theme, WRITE_OCCURRENCE_INDICATION, OCCURRENCE_INDICATION);
        applyDefault(theme, DEBUG_CURRENT_INSTRUCTION_POINTER, CURRENT_LINE);
        applyDefault(theme, DEBUG_SECONDARY_INSTRUCTION_POINTER, CURRENT_LINE);
    }

    private static void applyDefault(Map<String, ColorThemeSetting> theme,
            String key, String defaultKey) {
        if (!theme.containsKey(key))
            theme.put(key, theme.get(defaultKey));
    }

    /**
     * Returns all available color themes.
     * @return all available color themes.
     */
    public Set<ColorTheme> getThemes() {
        return new HashSet<ColorTheme>(themes.values());
    }

    /**
     * Returns the theme stored under the supplied name. 
     * @param name The name of the theme.
     * @return The requested theme or <code>null</code> if none was stored under
     *         the supplied name.
     */
    public ColorTheme getTheme(String name) {
        return themes.get(name);
    }

    /**
     * Changes the preferences of other plugins to apply the color theme.
     * @param theme The name of the color theme to apply.
     */
    public void applyTheme(String theme) {
        for (ThemePreferenceMapper editor : editors.values()) {
            editor.clear();
            if (themes.get(theme) != null)
                editor.map(themes.get(theme).getEntries(),
                           themes.get(theme).getMappings() == null ?
                               null : themes.get(theme).getMappings().get(editor.getPluginId()));

            try {
                editor.flush();
            } catch (BackingStoreException e) {
                // TODO: Show a proper error message (StatusManager).
                e.printStackTrace();
            }
        }
    }

    /**
     * Adds the color theme to the list and saves it to the preferences.
     * Existing themes will be overwritten with the new content.
     * @param input The input for theme file.
     * @throws TransformerException
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public void saveTheme(InputStream input) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        ParsedTheme theme = parseTheme(input, true);
        themes.put(theme.getTheme().getName(), theme.getTheme());
        IPreferenceStore store = getPreferenceStore();
        for (int i = 1;; i++)
            if (!store.contains("importedColorTheme" + i)) {
                store.putValue("importedColorTheme" + i, theme.getSource());
                break;
            }
    }

    protected static String documentToString(Document document) throws TransformerException {
        StringWriter writer = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(writer));
        return writer.toString();
    }
}
