package com.github.fhd.eclipsecolortheme;

import java.util.*;

import org.osgi.service.prefs.*;

import com.github.fhd.eclipsecolortheme.themepreferencemapper.*;
import com.github.fhd.eclipsecolortheme.themepreferencemapper.WebEditorMapper.Type;

/**
 * Loads and applies color themes.
 * TODO: Make the keys less Java specific and less redundant.
 */
public class ColorThemeManager {
    private Map<String, Map<String, String>> themes;
    private Set<ThemePreferenceMapper> editors;

    /** Creates a new color theme manager. */
    public ColorThemeManager() {
        themes = new HashMap<String, Map<String, String>>();
        themes.put("Inkpot", createInkpotTheme());
        themes.put("Zenburn", createZenburnTheme());

        for (Map<String, String> theme : themes.values())
            amendTheme(theme);

        editors = new HashSet<ThemePreferenceMapper>();
        editors.add(new TextEditorMapper());
        editors.add(new JavaEditorMapper());
        editors.add(new JavaPropertiesEditorMapper());
        editors.add(new WebEditorMapper(Type.XML));
        editors.add(new WebEditorMapper(Type.HTML));
        editors.add(new WebEditorMapper(Type.CSS));
        editors.add(new JavaScriptEditorMapper());
    }

    private static Map<String, String> createInkpotTheme() {
        Map<String, String> theme = new HashMap<String, String>();
        theme.put("foreground", color(207, 191, 173));
        theme.put("background", color(31, 31, 39));
        theme.put("selectionForeground", color(64, 64, 64));
        theme.put("selectionBackground", color(139, 139, 255));
        theme.put("currentLine", color(45, 45, 68));
        theme.put("lineNumber", color(43, 145, 175));
        theme.put("sourceHoverBackground", color(255, 255, 255));;
        theme.put("singleLineComment", color(205, 139, 0));
        theme.put("multiLineComment", color(205, 139, 0));
        theme.put("commentTaskTag", color(255, 139, 255));
        theme.put("class", color(135, 206, 250));
        theme.put("interface", color(135, 250, 196));
        theme.put("method", color(135, 206, 250));
        theme.put("methodDeclarationName", color(207, 191, 173));
        theme.put("bracket", color(207, 191, 173));
        theme.put("number", color(255, 205, 139));
        theme.put("string", color(255, 205, 139));
        theme.put("operator", color(207, 191, 173));
        theme.put("keyword", color(128, 139, 237));
        return theme;
    }

    private static Map<String, String> createZenburnTheme() {
        Map<String, String> theme = new HashMap<String, String>();
        theme.put("foreground", color(246, 243, 232));
        theme.put("background", color(64, 64, 64));
        theme.put("selectionForeground", color(0, 0, 0));
        theme.put("selectionBackground", color(137, 137, 65));
        theme.put("currentLine", color(80, 80, 80));
        theme.put("lineNumber", color(192, 192, 192));
        theme.put("searchResultIndication", color(70, 68, 103));
        theme.put("filteredSearchResultIndication", color(63, 63, 106));
        theme.put("occurrenceIndication", color(97, 97, 97));
        theme.put("writeOccurrenceIndication", color(148, 133, 103));
        theme.put("findScope", color(188, 173, 173));
        theme.put("currentIP", color(26, 89, 26));
        theme.put("secondaryIP", color(26, 89, 26));
        theme.put("sourceHoverBackground", color(161, 152, 121));
        theme.put("singleLineComment", color(127, 159, 127));
        theme.put("multiLineComment", color(127, 159, 127));
        theme.put("commentTaskTag", color(172, 193, 172));
        theme.put("javadoc", color(179, 181, 175));
        theme.put("javadocLink", color(168, 147, 204));
        theme.put("javadocTag", color(147, 147, 204));
        theme.put("javadocKeyword", color(204, 147, 147));
        theme.put("class", color(202, 230, 130));
        theme.put("interface", color(202, 230, 130));
        theme.put("method", color(223, 190, 149));
        theme.put("methodDeclarationName", color(223, 190, 149));
        theme.put("bracket", color(255, 255, 255));
        theme.put("number", color(138, 204, 207));
        theme.put("string", color(204, 147, 147));
        theme.put("operator", color(240, 239, 208));
        theme.put("keyword", color(239, 239, 175));
        theme.put("autoboxing", color(255, 187, 187));
        theme.put("annotation", color(128, 128, 128));
        theme.put("staticMethodInvocation", color(196, 196, 183));
        theme.put("localVariable", color(212, 196, 169));
        theme.put("localVariableDeclaration", color(212, 196, 169));
        theme.put("field", color(179, 183, 132));
        theme.put("staticField", color(147, 162, 204));
        theme.put("staticFinalField", color(83, 220, 205));
        theme.put("deprecatedMember", color(255, 255, 255));
        return theme;
    }

    private static String color(int r, int g, int b) {
        return r + "," + g + "," + b;
    }

    private static void amendTheme(Map<String, String> theme) {
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
