package com.github.eclipsecolortheme;

import static com.github.eclipsecolortheme.ColorThemeKeys.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
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
    private Set<ThemePreferenceMapper> editors;
    private static final ILog LOG = Activator.getDefault().getLog();

    /** Creates a new color theme manager. */
    public ColorThemeManager() {
        themes = new HashMap<String, ColorTheme>();
        readStockThemes(themes);
        readImportedThemes(themes);

        editors = new HashSet<ThemePreferenceMapper>();
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
                        ((GenericMapper) mapper).parseMapping(input);
                    }
                    editors.add(mapper);
                }
            }
        } catch (Exception ex) {
            LOG.log(new Status(Status.ERROR, Activator.PLUGIN_ID, ex
                    .getMessage()));
        }
    }

    private static void readStockThemes(Map<String, ColorTheme> themes) {
        IConfigurationElement[] config = Platform
                .getExtensionRegistry()
                .getConfigurationElementsFor(Activator.EXTENSION_POINT_ID_THEME);
        try {
            for (IConfigurationElement e : config) {
                String xml = e.getAttribute("file");
                String contributorPluginId = e.getContributor().getName();
                Bundle bundle = Platform.getBundle(contributorPluginId);
                InputStream input = (InputStream) bundle.getResource(xml)
                        .getContent();
                ColorTheme theme = parseTheme(input);
                amendThemeEntries(theme.getEntries());
                themes.put(theme.getName(), theme);
            }
        } catch (Exception e) {
            LOG.log(new Status(Status.ERROR, Activator.PLUGIN_ID, e
                    .getMessage()));
        }
    }

    private static void readImportedThemes(Map<String, ColorTheme> themes) {
        IPreferenceStore store = getPreferenceStore();

        for (int i = 1;; i++) {
            String xml = store.getString("importedColorTheme" + i);
            if (xml == null || xml.length() == 0)
                break;
            try {
                ColorTheme theme = parseTheme(new ByteArrayInputStream(
                        xml.getBytes()));
                amendThemeEntries(theme.getEntries());
                themes.put(theme.getName(), theme);
            } catch (Exception e) {
                LOG.log(new Status(Status.ERROR, Activator.PLUGIN_ID, e
                        .getMessage()));
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

    public static ColorTheme parseTheme(InputStream input)
            throws ParserConfigurationException, SAXException, IOException {
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

        return theme;
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
     * 
     * @return all available color themes.
     */
    public Set<ColorTheme> getThemes() {
        return new HashSet<ColorTheme>(themes.values());
    }

    /**
     * Returns the theme stored under the supplied name.
     * 
     * @param name
     *            The name of the theme.
     * @return The requested theme or <code>null</code> if none was stored under
     *         the supplied name.
     */
    public ColorTheme getTheme(String name) {
        return themes.get(name);
    }

    /**
     * Changes the preferences of other plugins to apply the color theme.
     * 
     * @param theme
     *            The name of the color theme to apply.
     */
    public void applyTheme(String theme) {
        for (ThemePreferenceMapper editor : editors) {
            editor.clear();
            if (themes.get(theme) != null)
                editor.map(themes.get(theme).getEntries());

            try {
                editor.flush();
            } catch (BackingStoreException e) {
                LOG.log(new Status(Status.ERROR, Activator.PLUGIN_ID, e
                        .getMessage()));
            }
        }
    }

    /**
     * Adds the color theme to the list and saves it to the preferences.
     * Existing themes will be overwritten with the new content.
     * 
     * @param content
     *            The content of the color theme file.
     * @return The saved color theme, or <code>null</code> if the theme was not
     *         valid.
     */
    public ColorTheme saveTheme(String content) {
        ColorTheme theme;
        try {
            theme = ColorThemeManager.parseTheme(new ByteArrayInputStream(
                    content.getBytes()));
            String name = theme.getName();
            themes.put(name, theme);
            IPreferenceStore store = getPreferenceStore();
            for (int i = 1;; i++)
                if (!store.contains("importedColorTheme" + i)) {
                    store.putValue("importedColorTheme" + i, content);
                    break;
                }
            return theme;
        } catch (Exception e) {
            LOG.log(new Status(Status.ERROR, Activator.PLUGIN_ID, e
                    .getMessage()));
            return null;
        }
    }

    /**
     * Check if a given theme is an imported theme
     * 
     * @param themeID
     *            /theme name
     * @return
     */
    public boolean isImportedTheme(String themeID) {
        if (themeID != null) {
            Map<String, ColorTheme> imported = new HashMap<String, ColorTheme>();
            ColorThemeManager.readImportedThemes(imported);
            return imported.containsKey(themeID);
        }
        return false;
    }

    /**
     * Remove a color theme from the preference store
     * 
     * @param theme
     */
    public boolean deleteImportedTheme(ColorTheme theme) {
        IPreferenceStore store = getPreferenceStore();

        for (int i = 1;; i++) {
            String xml = store.getString("importedColorTheme" + i);
            if (xml == null || xml.length() == 0)
                break;
            try {
                ColorTheme curtheme = parseTheme(new ByteArrayInputStream(
                        xml.getBytes()));
                if (curtheme.equals(theme)) {
                    store.setValue("importedColorTheme" + i, "");
                    themes.remove(theme.getName());
                    return true;
                }
            } catch (Exception e) {
                LOG.log(new Status(Status.ERROR, Activator.PLUGIN_ID, e
                        .getMessage()));
            }
        }
        return false;
    }
}
