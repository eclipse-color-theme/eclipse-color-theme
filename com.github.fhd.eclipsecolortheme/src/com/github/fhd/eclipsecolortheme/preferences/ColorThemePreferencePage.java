package com.github.fhd.eclipsecolortheme.preferences;

import org.eclipse.core.runtime.preferences.*;
import org.eclipse.jface.preference.*;
import org.eclipse.ui.*;
import org.osgi.service.prefs.*;

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
	    IEclipsePreferences prefs = new InstanceScope().getNode(
               "org.eclipse.ui.editors");
	    if ("dark".equals(getPreferenceStore().getString("colorTheme"))) {
	        prefs.putBoolean(
                    "AbstractTextEditor.Color.Foreground.SystemDefault",
                    false);
	        prefs.put("AbstractTextEditor.Color.Foreground", "255,255,255");
	        prefs.putBoolean(
	                "AbstractTextEditor.Color.Background.SystemDefault",
                    false);
	        prefs.put("AbstractTextEditor.Color.Background", "0,0,0");
	    } else {
	        prefs.remove("AbstractTextEditor.Color.Foreground.SystemDefault");
	        prefs.remove("AbstractTextEditor.Color.Foreground");
	        prefs.remove("AbstractTextEditor.Color.Background.SystemDefault");
	        prefs.remove("AbstractTextEditor.Color.Background");
	    }
	    try {
            prefs.flush();
        } catch (BackingStoreException e) {
            // TODO: Show a proper error message (StatusManager).
            e.printStackTrace();
        }
	    return super.performOk();
	}
}