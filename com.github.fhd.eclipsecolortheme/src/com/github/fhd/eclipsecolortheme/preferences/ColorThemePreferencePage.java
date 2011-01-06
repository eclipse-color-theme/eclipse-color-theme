package com.github.fhd.eclipsecolortheme.preferences;

import java.util.*;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.*;
import org.osgi.service.prefs.*;

import com.github.fhd.eclipsecolortheme.*;
import com.github.fhd.eclipsecolortheme.themepreferencemapper.*;

/** The preference page for managing color themes. */
public class ColorThemePreferencePage extends FieldEditorPreferencePage
                                      implements IWorkbenchPreferencePage {
    private RadioGroupFieldEditor colorThemeEditor;
    private ColorThemeCollection themes;
    private Set<ThemePreferenceMapper> editors;

    /** Creates a new color theme preference page. */
	public ColorThemePreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		themes = new ColorThemeCollection();

		editors = new HashSet<ThemePreferenceMapper>();
		editors.add(new TextEditorThemePreferenceMapper());
		editors.add(new JavaEditorThemePreferenceMapper());
	}

	@Override
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

	@Override
	public void init(IWorkbench workbench) {
	}

	@Override
	public boolean performOk() {
	    colorThemeEditor.store();
	    Map<String, String> theme =
	            themes.getTheme(getPreferenceStore().getString("colorTheme"));

	    for (ThemePreferenceMapper editor : editors) {
	        editor.clear();
	        if (theme != null)
	            editor.map(theme);

	        try {
	            editor.flush();
	        } catch (BackingStoreException e) {
	            // TODO: Show a proper error message (StatusManager).
	            e.printStackTrace();
	        }
	    }

	    return super.performOk();
	}
}