package com.github.fhd.eclipsecolortheme.preferences;

import java.util.*;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.*;

import com.github.fhd.eclipsecolortheme.*;

/** The preference page for managing color themes. */
public class ColorThemePreferencePage extends FieldEditorPreferencePage
                                      implements IWorkbenchPreferencePage {
    private ColorThemeManager colorThemeManager;
    private RadioGroupFieldEditor colorThemeEditor;

    /** Creates a new color theme preference page. */
	public ColorThemePreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		colorThemeManager = new ColorThemeManager();
	}

	@Override
	public void createFieldEditors() {
	    Set<String> themeNames = colorThemeManager.getThemeNames();
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
	    colorThemeManager.applyTheme(
                getPreferenceStore().getString("colorTheme"));
	    return super.performOk();
	}
}