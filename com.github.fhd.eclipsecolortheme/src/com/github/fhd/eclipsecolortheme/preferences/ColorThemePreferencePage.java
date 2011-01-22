package com.github.fhd.eclipsecolortheme.preferences;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.github.fhd.eclipsecolortheme.Activator;
import com.github.fhd.eclipsecolortheme.ColorThemeManager;

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
	    IWorkbenchPage activePage = PlatformUI.getWorkbench()
                                              .getActiveWorkbenchWindow()
                                              .getActivePage();

	    try {
	        Map<String, IEditorInput> formerEditors =
	            new HashMap<String, IEditorInput>();
	        for (IEditorReference editor : activePage.getEditorReferences())
	            formerEditors.put(editor.getId(), editor.getEditorInput());

	        if (!formerEditors.isEmpty()) {    
	            MessageBox box = new MessageBox(getShell(),
	                                            SWT.OK | SWT.CANCEL);
	            box.setText("Reopen editors");
	            box.setMessage("In order to change the color theme, all editors"
	            		       + " have to be closed and reopened.");
	            if (box.open() == SWT.CANCEL)
	                return false;

	            activePage.closeAllEditors(true);   
	        }

	        colorThemeEditor.store();
            colorThemeManager.applyTheme(
                    getPreferenceStore().getString("colorTheme"));

	        for (String id : formerEditors.keySet())
	            activePage.openEditor(formerEditors.get(id), id);
	    } catch (PartInitException e) {
            // TODO: Show a proper error message (StatusManager).
	        e.printStackTrace();
	    }

	    return super.performOk();
	}
}