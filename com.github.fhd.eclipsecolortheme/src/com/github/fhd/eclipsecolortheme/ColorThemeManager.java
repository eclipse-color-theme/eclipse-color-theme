package com.github.fhd.eclipsecolortheme;

import java.io.*;
import java.util.*;

import javax.xml.parsers.*;

import org.osgi.service.prefs.*;
import org.w3c.dom.*;
import org.xml.sax.*;

import com.github.fhd.eclipsecolortheme.mapper.*;
import com.github.fhd.eclipsecolortheme.mapper.WebEditorMapper.Type;

/** Loads and applies color themes. */
public class ColorThemeManager {
    private static final String[] THEME_FILES = new String[] {
            "zenburn.xml",
            "inkpot.xml",
            "vibrantink.xml"
    };
    private Map<String, Map<String, String>> themes;
    private Set<ThemePreferenceMapper> editors;

    /** Creates a new color theme manager. */
    public ColorThemeManager() {
        themes = new HashMap<String, Map<String, String>>();
        for (String themeFile : THEME_FILES) {
            try {
                InputStream input =  Thread.currentThread()
                                           .getContextClassLoader()
                                           .getResourceAsStream(
                                "com/github/fhd/eclipsecolortheme/themes/"
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

        editors = new HashSet<ThemePreferenceMapper>();
        editors.add(new TextEditorMapper());
        editors.add(new JavaEditorMapper());
        editors.add(new JavaPropertiesEditorMapper());
        editors.add(new WebEditorMapper(Type.XML));
        editors.add(new WebEditorMapper(Type.HTML));
        editors.add(new WebEditorMapper(Type.CSS));
        editors.add(new JavaScriptEditorMapper());
        editors.add(new CppEditorMapper());
    }

    private static ColorTheme parseTheme(InputStream input)
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

    private static class ColorTheme {
        private String name;
        private Map<String, String> entries;

        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }

        public Map<String, String> getEntries() {
            return entries;
        }

        public void setEntries(Map<String, String> entries) {
            this.entries = entries;
        }
    }

    private static void amendThemeEntries(Map<String, String> theme) {
        applyDefault(theme, "method", "foreground");
        applyDefault(theme, "field", "foreground");
        applyDefault(theme, "javadoc", "multiLineComment");
        applyDefault(theme, "javadocLink", "javadoc");
        applyDefault(theme, "javadocTag", "javadoc");
        applyDefault(theme, "javadocKeyword", "javadoc");
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
}
