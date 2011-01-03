package com.github.fhd.eclipsecolortheme.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.*;

import com.github.fhd.eclipsecolortheme.*;

public class ColorThemePreferencePage extends FieldEditorPreferencePage
                                      implements IWorkbenchPreferencePage {
    private RadioGroupFieldEditor colorThemeEditor;

	public ColorThemePreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	public void createFieldEditors() {
	    String[][] choices = new String[][] {{"Default", "default"},
	                                         {"Dark", "dark"}};

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
	    return super.performOk();
	}
}