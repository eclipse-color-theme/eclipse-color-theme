package com.github.fhd.eclipsecolortheme.preferences;

import java.util.*;

public class ColorThemeCollection {
    Map<String, Map<String, String>> themes;

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
        return theme;
    }

    private static String color(int r, int g, int b) {
        return r + "," + g + "," + b;
    }

    public Set<String> getThemeNames() {
        return themes.keySet();
    }

    public Map<String, String> getTheme(String name) {
        return themes.get(name);
    }
}
