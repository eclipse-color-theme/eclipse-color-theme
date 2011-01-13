package com.github.fhd.eclipsecolortheme.mapper;

import java.util.*;

/** Maps color themes to preferences for Eclipse's Text editor. */
public class TextEditorMapper extends ThemePreferenceMapper {
    /** Creates a new color theme mapper. */
    public TextEditorMapper() {
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
                      entry(theme.get("foreground")));
        putPreference("AbstractTextEditor.Color.Background",
                      entry(theme.get("background")));
        putPreference("AbstractTextEditor.Color.SelectionForeground",
                      entry(theme.get("selectionForeground")));
        putPreference("AbstractTextEditor.Color.SelectionBackground",
                      entry(theme.get("selectionBackground")));
        putPreference("currentLineColor", entry(theme.get("currentLine")));
        putPreference("lineNumberColor", entry(theme.get("lineNumber")));
        putPreference("filteredSearchResultIndicationColor",
                      entry(theme.get("filteredSearchResultIndication")));
        putPreference("occurrenceIndicationColor",
                      entry(theme.get("occurrenceIndication")));
        putPreference("javaScriptOccurrenceIndicationColor",
                      entry(theme.get("occurrenceIndication")));
        putPreference("org.eclipse.cdt.ui.occurrenceIndicationColor",
                      entry(theme.get("occurrenceIndication")));
        putPreference("AbstractTextEditor.Color.FindScope",
                      entry(theme.get("findScope")));
        putPreference("secondaryIPColor", entry(theme.get("secondaryIP")));
        putPreference("writeOccurrenceIndicationColor",
                      entry(theme.get("writeOccurrenceIndication")));
        putPreference("currentIPColor", entry(theme.get("currentIP")));
        putPreference("searchResultIndicationColor",
                      entry(theme.get("searchResultIndication")));
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