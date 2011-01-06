package com.github.fhd.eclipsecolortheme.themepreferencemapper;

import java.util.*;

/** Maps color themes to preferences for Eclipse's Text Editor. */
public class TextEditorThemePreferenceMapper extends ThemePreferenceMapper {
    /** Creates a new color theme mapper. */
    public TextEditorThemePreferenceMapper() {
        super("org.eclipse.ui.editors");
    }

    @Override
    public void map(Map<String, String> theme) {
        preferences.putBoolean(
                "AbstractTextEditor.Color.Foreground.SystemDefault", true);
        preferences.putBoolean(
                "AbstractTextEditor.Color.Background.SystemDefault", true);
        preferences.putBoolean(
                "AbstractTextEditor.Color.SelectionBackground.SystemDefault",
                true);
        preferences.putBoolean(
                "AbstractTextEditor.Color.SelectionForeground.SystemDefault",
                true);

        putPreference("AbstractTextEditor.Color.Foreground",
                      theme.get("foreground"));
        putPreference("AbstractTextEditor.Color.Background",
                      theme.get("background"));
        putPreference("AbstractTextEditor.Color.SelectionForeground",
                      theme.get("selectionForeground"));
        putPreference("AbstractTextEditor.Color.SelectionBackground",
                      theme.get("selectionBackground"));
        putPreference("currentLineColor", theme.get("currentLine"));
        putPreference("lineNumberColor", theme.get("lineNumber"));
        putPreference("filteredSearchResultIndicationColor",
                      theme.get("filteredSearchResultIndication"));
        putPreference("occurrenceIndicationColor",
                      theme.get("occurenceIndication"));
        putPreference("AbstractTextEditor.Color.FindScope",
                      theme.get("findScope"));
        putPreference("secondaryIPColor", theme.get("secondaryIP"));
        putPreference("writeOccurrenceIndicationColor",
                      theme.get("writeOccurrenceIndication"));
        putPreference("currentIPColor", theme.get("currentIP"));
        putPreference("searchResultIndicationColor",
                      theme.get("searchResultIndication"));
    }

    @Override
    protected void putDependentEntries(String key) {
        if ("AbstractTextEditor.Color.Foreground".equals(key))
            preferences.putBoolean(
                    "AbstractTextEditor.Color.Foreground.SystemDefault", false);
        else if ("AbstractTextEditor.Color.Background".equals(key))
            preferences.putBoolean(
                    "AbstractTextEditor.Color.Background.SystemDefault", false);
        else if ("AbstractTextEditor.Color.SelectionForeground".equals(key))
            preferences.putBoolean(
                    "AbstractTextEditor.Color.SelectionBackground.SystemDefault",
                    false);
        else if ("AbstractTextEditor.Color.SelectionBackground".equals(key))
            preferences.putBoolean(
                    "AbstractTextEditor.Color.SelectionForeground.SystemDefault",
                    false);
    }

    @Override
    public void clear() {
        preferences.remove("AbstractTextEditor.Color.Foreground.SystemDefault");
        preferences.remove("AbstractTextEditor.Color.Background.SystemDefault");
        preferences.remove(
                "AbstractTextEditor.Color.SelectionBackground.SystemDefault");
        preferences.remove(
                "AbstractTextEditor.Color.SelectionForeground.SystemDefault");
        preferences.remove("AbstractTextEditor.Color.Foreground");
        preferences.remove("AbstractTextEditor.Color.Background");
        preferences.remove("AbstractTextEditor.Color.SelectionForeground");
        preferences.remove("AbstractTextEditor.Color.SelectionBackground");
        preferences.remove("currentLineColor");
        preferences.remove("lineNumberColor");
        preferences.remove("filteredSearchResultIndicationColor");
        preferences.remove("occurrenceIndicationColor");
        preferences.remove("AbstractTextEditor.Color.FindScope");
        preferences.remove("secondaryIPColor");
        preferences.remove("writeOccurrenceIndicationColor");
        preferences.remove("currentIPColor");
        preferences.remove("searchResultIndicationColor");
    }
}