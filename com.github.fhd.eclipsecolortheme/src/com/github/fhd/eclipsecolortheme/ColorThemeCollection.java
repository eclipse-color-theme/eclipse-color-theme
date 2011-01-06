package com.github.fhd.eclipsecolortheme;

import java.util.*;

/**
 * A collection of color themes.
 * TODO: The keys are Java specific right now. Generalise them.
 * XXX: One class per theme would be more flexible.
 */
public class ColorThemeCollection {
    private Map<String, Map<String, String>> themes;

    /** Creates a new color theme collection. */
    public ColorThemeCollection() {
        themes = new HashMap<String, Map<String, String>>();
        themes.put("Inkpot", createInkpotTheme());
        themes.put("Zenburn", createZenburnTheme());
    }

    private static Map<String, String> createInkpotTheme() {
        Map<String, String> theme = new HashMap<String, String>();
        theme.put("foreground", color(207, 191, 173));
        theme.put("background", color(31, 31, 39));
        theme.put("selectionForeground", color(64, 64, 64));
        theme.put("selectionBackground", color(139, 139, 255));
        theme.put("currentLine", color(45, 45, 68));
        theme.put("lineNumber", color(43, 145, 175));
        theme.put("contentAssistProposalsForeground", color(0, 0, 0));
        theme.put("contentAssistProposalsBackground", color(255, 255, 255));
        theme.put("singleLineComment", color(205, 139, 0));
        theme.put("multiLineComment", color(205, 139, 0));
        theme.put("commentTaskTag", color(255, 139, 255));
        theme.put("sourceHoverBackground", color(255, 255, 255));;
        theme.put("number", color(255, 205, 139));
        theme.put("string", color(255, 205, 139));
        theme.put("bracket", color(207, 191, 173));
        theme.put("operator", color(207, 191, 173));
        theme.put("keyword", color(128, 139, 237));
        theme.put("class", color(135, 206, 250));
        theme.put("interface", color(135, 250, 196));
        theme.put("method", color(135, 206, 250));
        theme.put("methodDeclarationName", color(207, 191, 173));
        return theme;
    }

    private static Map<String, String> createZenburnTheme() {
        Map<String, String> theme = new HashMap<String, String>();
        theme.put("foreground", color(246,243,232));
        theme.put("background", color(64,64,64));
        theme.put("selectionForeground", color(0,0,0));
        theme.put("selectionBackground", color(137,137,65));
        theme.put("currentLine", color(80,80,80));
        theme.put("lineNumber", color(192,192,192));
        theme.put("filteredSearchResultIndication", color(63,63,106));
        theme.put("occurrenceIndication", color(97,97,97));
        theme.put("findScope", color(188,173,173));
        theme.put("secondaryIP", color(26,89,26));
        theme.put("writeOccurrenceIndication", color(148,133,103));
        theme.put("currentIP", color(26,89,26));
        theme.put("searchResultIndication", color(70,68,103));
        theme.put("contentAssistProposalsForeground", color(0, 0, 0));
        theme.put("contentAssistProposalsBackground", color(255, 255, 255));
        theme.put("commentTaskTag", color(172,193,172));
        theme.put("javadoc", color(179, 181, 175));
        theme.put("javadocLink", color(168, 147, 204));
        theme.put("javadocSingleLineComment", color(127, 159, 127));
        theme.put("localVariable", color(212, 196, 169));
        theme.put("staticFinalField", color(83, 220, 205));
        theme.put("bracket", color(255, 255, 255));
        theme.put("field", color(179, 183, 132));
        theme.put("staticMethodInvocation", color(196, 196, 183));
        theme.put("contentAssistParametersForeground", color(246, 243, 232));
        theme.put("contentAssistParametersBackground", color(36, 36, 36));
        theme.put("number", color(138, 04, 07));
        theme.put("sourceHoverBackground", color(161, 52, 21));
        theme.put("deprecatedMember", color(255, 55, 55));
        theme.put("class", color(202, 30, 30));
        theme.put("operator", color(240, 39, 208));
        theme.put("method", color(223, 90, 49));
        theme.put("methodDeclarationName", color(223, 90, 49));
        theme.put("autoboxing", color(255, 87, 87));
        theme.put("keyword", color(239, 39, 75));
        theme.put("string", color(204, 47, 47));
        theme.put("localVariableDeclaration", color(212, 96, 69));
        theme.put("javadocKeyword", color(204, 47, 47));
        theme.put("annotation", color(128, 28, 28));
        theme.put("staticField", color(147, 62, 04));
        theme.put("multiLineComment", color(127, 59, 27));
        theme.put("javadocTag", color(147, 47, 04));
        return theme;
    }

    private static String color(int r, int g, int b) {
        return r + "," + g + "," + b;
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
}
