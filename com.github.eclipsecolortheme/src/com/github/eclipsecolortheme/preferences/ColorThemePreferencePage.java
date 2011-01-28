package com.github.eclipsecolortheme.preferences;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.github.eclipsecolortheme.Activator;
import com.github.eclipsecolortheme.ColorTheme;
import com.github.eclipsecolortheme.ColorThemeManager;

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
                "Current color theme:", 1, choices, getFieldEditorParent()) {
            @Override
            protected void doLoadDefault() {
                colorThemeManager.clearImportedThemes();
                super.doLoadDefault();
            }
        };
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

	@Override
	protected void contributeButtons(Composite parent) {
        Button button = new Button(parent, SWT.NONE);
        button.setText("&Import a theme...");
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                FileDialog dialog = new FileDialog(getShell());
                String file= dialog.open();
                ColorTheme theme;
                try {
                    String content = readFile(new File(file));
                    theme = colorThemeManager.saveTheme(content);
                } catch (IOException e) {
                    theme = null;
                }
                MessageBox box = new MessageBox(getShell(), SWT.OK);
                if (theme != null) {
                    // TODO: Add the theme to the list immediately.
                    box.setText("Theme imported");
                    box.setMessage("The theme '" + theme.getName() + "' has " +
                                   "been imported successfully. However, in " +
                                   "order to use it, please close the " +
                                   "preferences window and open it again. " +
                                   "This issue will be addressed soon.");
                } else {
                    box.setText("Theme not imported");
                    box.setMessage("This is not a valid theme file.");
                }
                box.open();
            }
        });
	}

	private static String readFile(File file) throws IOException {
	    Reader in = new BufferedReader(new FileReader(file));
	    StringBuilder sb = new StringBuilder();
	    char[] chars = new char[1 << 16];
	    int length;
	    while ((length = in.read(chars)) > 0)
	        sb.append(chars, 0, length);
	    return sb.toString();
	}
}