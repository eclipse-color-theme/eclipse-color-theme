package com.github.fhd.eclipsecolortheme.preferences;

import java.util.*;

import org.eclipse.core.runtime.preferences.*;
import org.eclipse.jface.preference.*;
import org.eclipse.ui.*;
import org.osgi.service.prefs.*;

import com.github.fhd.eclipsecolortheme.*;

public class ColorThemePreferencePage extends FieldEditorPreferencePage
                                      implements IWorkbenchPreferencePage {
    private RadioGroupFieldEditor colorThemeEditor;
    private ColorThemeCollection themes;

	public ColorThemePreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		themes = new ColorThemeCollection();
	}

	public void createFieldEditors() {
	    Set<String> themeNames = themes.getThemeNames();
	    String[][] choices = new String[themeNames.size() + 1][2];
	    int i = 0;
	    choices[i++] = new String[] {"Default", "Default"};
        for (String theme : themeNames)
	        choices[i++] = new String[] {theme, theme};

	    colorThemeEditor = new RadioGroupFieldEditor("colorTheme",
		                                             "Current color theme:", 1,
		                                             choices,
		                                             getFieldEditorParent());
	    addField(colorThemeEditor);
	}

	public void init(IWorkbench workbench) {
	}

	@Override
	public boolean performOk() {
	    colorThemeEditor.store();
	    IEclipsePreferences prefs = new InstanceScope().getNode(
               "org.eclipse.ui.editors");
	    Map<String, String> theme =
	            themes.getTheme(getPreferenceStore().getString("colorTheme"));

	    if (theme == null)
	        clearPrefs(prefs);
	    else
	        applyTheme(prefs, theme);

	    try {
            prefs.flush();
        } catch (BackingStoreException e) {
            // TODO: Show a proper error message (StatusManager).
            e.printStackTrace();
        }
	    return super.performOk();
	}

    private void applyTheme(IEclipsePreferences prefs,
                            Map<String, String> theme) {
        prefs.putBoolean("AbstractTextEditor.Color.Foreground.SystemDefault",
                         false);
        prefs.putBoolean("AbstractTextEditor.Color.Background.SystemDefault",
                         false);
        prefs.putBoolean(
                "AbstractTextEditor.Color.SelectionBackground.SystemDefault",
                false);
        prefs.putBoolean(
                "AbstractTextEditor.Color.SelectionForeground.SystemDefault",
                false);
        prefs.put("AbstractTextEditor.Color.Foreground",
                  theme.get("foreground"));
        prefs.put("AbstractTextEditor.Color.Background",
                  theme.get("background"));
        prefs.put("AbstractTextEditor.Color.SelectionForeground",
                  theme.get("selectionForeground"));
        prefs.put("AbstractTextEditor.Color.SelectionBackground",
                  theme.get("selectionBackground"));
        prefs.put("currentLineColor", theme.get("currentLine"));
        prefs.put("lineNumberColor", theme.get("lineNumber"));
        prefs.put("filteredSearchResultIndicationColor",
                  theme.get("filteredSearchResultIndication"));
        prefs.put("occurrenceIndicationColor",
                  theme.get("occurenceIndication"));
        prefs.put("AbstractTextEditor.Color.FindScope",
                  theme.get("findScope"));
        prefs.put("secondaryIPColor", theme.get("secondaryIP"));
        prefs.put("writeOccurrenceIndicationColor",
                  theme.get("writeOccurrenceIndication"));
        prefs.put("currentIPColor", theme.get("currentIP"));
        prefs.put("searchResultIndicationColor",
                  theme.get("searchResultIndication"));
    }

    private void clearPrefs(IEclipsePreferences prefs) {
        prefs.remove("AbstractTextEditor.Color.Foreground.SystemDefault");
        prefs.remove("AbstractTextEditor.Color.Background.SystemDefault");
        prefs.remove(
                "AbstractTextEditor.Color.SelectionBackground.SystemDefault");
        prefs.remove(
                "AbstractTextEditor.Color.SelectionForeground.SystemDefault");
        prefs.remove("AbstractTextEditor.Color.Foreground");
        prefs.remove("AbstractTextEditor.Color.Background");
        prefs.remove("AbstractTextEditor.Color.SelectionForeground");
        prefs.remove("AbstractTextEditor.Color.SelectionBackground");
        prefs.remove("currentLineColor");
        prefs.remove("lineNumberColor");
        prefs.remove("filteredSearchResultIndicationColor");
        prefs.remove("occurrenceIndicationColor");
        prefs.remove("AbstractTextEditor.Color.FindScope");
        prefs.remove("secondaryIPColor");
        prefs.remove("writeOccurrenceIndicationColor");
        prefs.remove("currentIPColor");
        prefs.remove("searchResultIndicationColor");
    }
}