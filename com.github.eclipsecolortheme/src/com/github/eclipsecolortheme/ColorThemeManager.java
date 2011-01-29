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

import org.eclipse.jface.preference.IPreferenceStore;
import org.osgi.service.prefs.BackingStoreException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.github.eclipsecolortheme.mapper.AntEditorMapper;
import com.github.eclipsecolortheme.mapper.CppEditorMapper;
import com.github.eclipsecolortheme.mapper.GenericMapper;
import com.github.eclipsecolortheme.mapper.JavaEditorMapper;
import com.github.eclipsecolortheme.mapper.JavaPropertiesEditorMapper;
import com.github.eclipsecolortheme.mapper.JavaScriptEditorMapper;
import com.github.eclipsecolortheme.mapper.PhpEditorMapper;
import com.github.eclipsecolortheme.mapper.SqlEditorMapper;
import com.github.eclipsecolortheme.mapper.TextEditorMapper;
import com.github.eclipsecolortheme.mapper.ThemePreferenceMapper;
import com.github.eclipsecolortheme.mapper.WebEditorMapper;
import com.github.eclipsecolortheme.mapper.WebEditorMapper.Type;

/** Loads and applies color themes. */
public class ColorThemeManager {
    private static final String[] THEME_FILES = new String[] {
            "zenburn.xml",
            "inkpot.xml",
            "vibrantink.xml",
            "oblivion.xml",
            "obsidian.xml",
            "tango.xml",
            "havenjark.xml"
    };
    private Map<String, Map<String, String>> themes;
    private Set<ThemePreferenceMapper> editors;

    /** Creates a new color theme manager. */
    public ColorThemeManager() {
        themes = new HashMap<String, Map<String, String>>();
        readStockThemes(themes);
        readImportedThemes(themes);

        editors = new HashSet<ThemePreferenceMapper>();
        editors.add(new TextEditorMapper());
        editors.add(new JavaEditorMapper());
        editors.add(new JavaPropertiesEditorMapper());
        editors.add(new WebEditorMapper(Type.XML));
        editors.add(new WebEditorMapper(Type.HTML));
        editors.add(new WebEditorMapper(Type.CSS));
        editors.add(new JavaScriptEditorMapper());
        editors.add(new CppEditorMapper());
        editors.add(new PhpEditorMapper());
        editors.add(new AntEditorMapper());
        editors.add(new SqlEditorMapper());
        editors.add(new GenericMapper("org.python.pydev"));
    }

    private static void readStockThemes(
            Map<String, Map<String, String>> themes) {
        for (String themeFile : THEME_FILES) {
            try {
                InputStream input =  Thread.currentThread()
                                           .getContextClassLoader()
                                           .getResourceAsStream(
                                "com/github/eclipsecolortheme/themes/"
                                + themeFile);
                ColorTheme theme = parseTheme(input);
                amendThemeEntries(theme.getEntries());
                themes.put(theme.getName(), theme.getEntries());
            } catch (Exception e) {
                System.err.println("Error while parsing theme from file: '"
                                   + themeFile + "'");
                e.printStackTrace();
            }
        }
    }

    private static void readImportedThemes(
            Map<String, Map<String, String>> themes) {
        IPreferenceStore store = getPreferenceStore();
        
        for (int i = 1; ; i++) {
            String xml = store.getString("importedColorTheme" + i);
            if (xml.isEmpty())
                break;
            try {
                ColorTheme theme =
                        parseTheme(new ByteArrayInputStream(xml.getBytes()));
                amendThemeEntries(theme.getEntries());
                themes.put(theme.getName(), theme.getEntries());
            } catch (Exception e) {
                System.err.println("Error while parsing imported theme");
                e.printStackTrace();
            }
        }
    }

    public void clearImportedThemes() {
        IPreferenceStore store = getPreferenceStore();
        int i = 1;
        while (store.contains("importedColorThemeName" + i)
                || store.contains("importedColorTheme" + i)) {
            store.setToDefault("importedColorThemeName" + i);
            store.setToDefault("importedColorTheme" + i);
            i++;
        }
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
        theme.setName(root.getAttribute("name"));

        Map<String, String> entries = new HashMap<String, String>();
        NodeList entryNodes = root.getChildNodes();
        for (int i = 0; i < entryNodes.getLength(); i++) {
            Node entryNode = entryNodes.item(i);
            if (entryNode.hasAttributes()) {
                entries.put(entryNode.getNodeName(),
                            entryNode.getAttributes().getNamedItem("color")
                            .getNodeValue());
            }
        }
        theme.setEntries(entries);

        return theme;
    }

    private static void amendThemeEntries(Map<String, String> theme) {
        applyDefault(theme, METHOD, FOREGROUND);
        applyDefault(theme, FIELD, FOREGROUND);
        applyDefault(theme, JAVADOC, MULTI_LINE_COMMENT);
        applyDefault(theme, JAVADOC_LINK, JAVADOC);
        applyDefault(theme, JAVADOC_TAG, JAVADOC);
        applyDefault(theme, JAVADOC_KEYWORD, JAVADOC);
        applyDefault(theme, OCCURRENCE_INDICATION, BACKGROUND);
        applyDefault(theme, WRITE_OCCURRENCE_INDICATION, OCCURRENCE_INDICATION);
    }

    private static void applyDefault(Map<String, String> theme, String key,
                                     String defaultKey) {
        if (!theme.containsKey(key))
            theme.put(key, theme.get(defaultKey));
    }
    
    /**
     * Returns the names of all available color themes.
     * @return the names of all available color themes.
     */
    public Set<String> getThemeNames() {
        return themes.keySet();
    }

    /**
     * Returns the theme stored under @a name.
     * @param name The theme to return.
     * @return The requested theme or <code>null</code> if none with that name
     *         exists.
     */
    public Map<String, String> getTheme(String name) {
        return themes.get(name);
    }

    /**
     * Changes the preferences of other plugins to apply the color theme.
     * @param theme The name of the color theme to apply.
     */
    public void applyTheme(String theme) {
        for (ThemePreferenceMapper editor : editors) {
            editor.clear();
            if (themes.get(theme) != null)
                editor.map(themes.get(theme));

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
     * @param content The content of the color theme file.
     * @return The saved color theme, or <code>null</code> if the theme was not
     *         valid.
     */
    public ColorTheme saveTheme(String content) {
        ColorTheme theme;
        try {
            theme = ColorThemeManager.parseTheme(
                    new ByteArrayInputStream(content.getBytes()));
            String name = theme.getName();
            themes.put(name, theme.getEntries());
            IPreferenceStore store = getPreferenceStore();
            for (int i = 1; ; i++) {
                if (store.contains("importedColorThemeName" + i)&& store.getString("importedColorThemeName" + i).equals(name)) {
                    store.putValue("importedColorTheme" + i, content);
                    break;
                }
                if (!store.contains("importedColorTheme" + i)) {
                    store.putValue("importedColorThemeName" + i, name);
                    store.putValue("importedColorTheme" + i, content);
                    break;
                }
            }
            return theme;
        } catch (Exception e) {
            return null;
        }
    }
}
