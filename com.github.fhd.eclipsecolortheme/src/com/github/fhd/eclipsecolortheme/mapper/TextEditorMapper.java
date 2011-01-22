package com.github.fhd.eclipsecolortheme.mapper;

import static com.github.fhd.eclipsecolortheme.ColorThemeKeys.*;

import java.util.Map;

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
                      entry(theme.get(FOREGROUND)));
        putPreference("AbstractTextEditor.Color.Background",
                      entry(theme.get(BACKGROUND)));
        putPreference("AbstractTextEditor.Color.SelectionForeground",
                      entry(theme.get(SELECTION_FOREGROUND)));
        putPreference("AbstractTextEditor.Color.SelectionBackground",
                      entry(theme.get(SELECTION_BACKGROUND)));
        putPreference("currentLineColor", entry(theme.get(CURRENT_LINE)));
        putPreference("lineNumberColor", entry(theme.get(LINE_NUMBER)));
        putPreference("filteredSearchResultIndicationColor",
                      entry(theme.get(FILTERED_SEARCH_RESULT_INDICATION)));
        putPreference("occurrenceIndicationColor",
                      entry(theme.get(OCCURRENCE_INDICATION)));
        putPreference("javaScriptOccurrenceIndicationColor",
                      entry(theme.get(OCCURRENCE_INDICATION)));
        putPreference("org.eclipse.cdt.ui.occurrenceIndicationColor",
                      entry(theme.get(OCCURRENCE_INDICATION)));
        putPreference("deletionIndicationColor",
                      entry(theme.get(DELETION_INDICATION)));
        putPreference("AbstractTextEditor.Color.FindScope",
                      entry(theme.get(FIND_SCOPE)));
        putPreference("printMarginColor", entry(theme.get(PRINT_MARGIN)));
        putPreference("writeOccurrenceIndicationColor",
                      entry(theme.get(WRITE_OCCURRENCE_INDICATION)));
        putPreference("searchResultIndicationColor",
                      entry(theme.get(SEARCH_RESULT_INDICATION)));
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
        preferences.remove("javaScriptOccurrenceIndicationColor");
        preferences.remove("org.eclipse.cdt.ui.occurrenceIndicationColor");
        preferences.remove("deletionIndicationColor");
        preferences.remove("AbstractTextEditor.Color.FindScope");
        preferences.remove("printMarginColor");
        preferences.remove("writeOccurrenceIndicationColor");
        preferences.remove("searchResultIndicationColor");
    }
}