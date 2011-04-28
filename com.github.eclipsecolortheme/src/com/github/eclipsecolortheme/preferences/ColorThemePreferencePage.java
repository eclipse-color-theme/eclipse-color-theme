package com.github.eclipsecolortheme.preferences;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
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
public class ColorThemePreferencePage extends PreferencePage
                                      implements IWorkbenchPreferencePage {
    private ColorThemeManager colorThemeManager = new ColorThemeManager();
    private Composite container;
    private List themeSelectionList;
    private Composite themeSelection;
    private Composite themeDetails;
    private Label authorLabel;
    private Link websiteLink;
    private Browser browser;

    /** Creates a new color theme preference page. */
	public ColorThemePreferencePage() {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	public void init(IWorkbench workbench) {
	}

	@Override
	protected Control createContents(Composite parent) {
	    container = new Composite(parent, SWT.NONE);
	    GridData gridData = new GridData();
	    GridLayout containerLayout = new GridLayout(1, true);
        container.setLayout(containerLayout);

        Label themeSelectionLabel = new Label(container, SWT.NONE);
        themeSelectionLabel.setText("Theme:");
        themeSelectionLabel.setLayoutData(gridData);

        gridData = new GridData(GridData.FILL_BOTH);
        themeSelection = new Composite(container, SWT.NONE);
        GridLayout themeSelectionLayout = new GridLayout(2, false);
        themeSelectionLayout.marginWidth = 0;
        themeSelectionLayout.marginHeight = 0;
        themeSelection.setLayout(themeSelectionLayout);
        themeSelection.setLayoutData(gridData);
        
        gridData = new GridData(GridData.FILL_BOTH);
        gridData.minimumWidth = 200;
        themeSelectionList = new List(themeSelection, SWT.BORDER);
        themeSelectionList.setLayoutData(gridData);
        fillThemeSelectionList();

        gridData = new GridData();
        gridData.widthHint = 400;
        gridData.verticalAlignment = SWT.TOP;
        GridLayout themeDetailsLayout = new GridLayout(1, true);
        themeDetailsLayout.marginWidth = 0;
        themeDetailsLayout.marginHeight = 0;
        themeDetails = new Composite(themeSelection, SWT.NONE);
        themeDetails.setLayoutData(gridData);
        themeDetails.setLayout(themeDetailsLayout);
        gridData = new GridData(GridData.FILL_HORIZONTAL);
        gridData.heightHint = 308;
        browser = new Browser(themeDetails, SWT.BORDER);
        browser.setLayoutData(gridData);
        browser.setText("<html><body></body></html>");
        authorLabel = new Label(themeDetails, SWT.NONE);
        websiteLink = new Link(themeDetails, SWT.NONE);

        themeSelectionList.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                updateDetails(colorThemeManager.getTheme(
                        themeSelectionList.getSelection()[0]));
            }
        });
        
        String activeThemeName = getPreferenceStore().getString("colorTheme");
        if (colorThemeManager.getTheme(activeThemeName) == null)
            activeThemeName = "Default";
        themeSelectionList.setSelection(new String[] {activeThemeName});
        updateDetails(colorThemeManager.getTheme(activeThemeName));

        Link ectLink = new Link(container, SWT.NONE);
        ectLink.setText("Download more themes or create your own on "
                        + "<a>eclipsecolorthemes.org</a>.");
        setLinkTarget(ectLink, "http://eclipsecolorthemes.org");
        return container;
	}

    private void fillThemeSelectionList() {
        Set<ColorTheme> themes = colorThemeManager.getThemes();
        java.util.List<String> themeNames = new LinkedList<String>();
        for (ColorTheme theme : themes)
        	themeNames.add(theme.getName());
        Collections.sort(themeNames);
        themeNames.add(0, "Default");
        themeSelectionList.setItems(
                themeNames.toArray(new String[themeNames.size()]));
    }

	private static void setLinkTarget(Link link, final String target) {
        link.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                Program.launch(target);
            }
        });
	}

    private void updateDetails(ColorTheme theme) {
        if (theme == null)
            themeDetails.setVisible(false);
        else {
            authorLabel.setText("Created by " + theme.getAuthor());
            String website = theme.getWebsite();
            if (website == null || website.isEmpty())
                websiteLink.setVisible(false);
            else {
                websiteLink.setText("<a>" + website + "</a>");
                for (Listener listener : websiteLink.getListeners(
                        SWT.Selection))
                    websiteLink.removeListener(SWT.Selection, listener);
                setLinkTarget(websiteLink, website);
                websiteLink.setVisible(true);
            }
            String id = theme.getId();
            browser.setUrl(
                    "http://www.eclipsecolorthemes.org/static/themes/java/"
                    + id + ".html");
            themeDetails.setVisible(true);
            authorLabel.pack();
            websiteLink.pack();
        }
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

	        String selectedThemeName = themeSelectionList.getSelection()[0];
	        getPreferenceStore().setValue("colorTheme", selectedThemeName);
            colorThemeManager.applyTheme(selectedThemeName);

	        for (String id : formerEditors.keySet())
	            activePage.openEditor(formerEditors.get(id), id);
	    } catch (PartInitException e) {
            // TODO: Show a proper error message (StatusManager).
	        e.printStackTrace();
	    }

	    return super.performOk();
	}

	@Override
	protected void performDefaults() {
	    getPreferenceStore().setToDefault("colorTheme");
	    colorThemeManager.clearImportedThemes();
	    reloadThemeSelectionList();
	    super.performDefaults();
	}

	@Override
	protected void contributeButtons(Composite parent) {
        Button button = new Button(parent, SWT.NONE);
        button.setText("&Import a theme...");
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                FileDialog dialog = new FileDialog(getShell());
                String file = dialog.open();
                ColorTheme theme;
                try {
                    String content = readFile(new File(file));
                    theme = colorThemeManager.saveTheme(content);
                } catch (IOException e) {
                    theme = null;
                }
                if (theme != null) {
                    reloadThemeSelectionList();
                } else {
                    MessageBox box = new MessageBox(getShell(), SWT.OK);
                    box.setText("Theme not imported");
                    box.setMessage("This is not a valid theme file.");
                    box.open();
                }
            }
        });
	}

    private void reloadThemeSelectionList() {
        themeSelectionList.removeAll();
        fillThemeSelectionList();
        themeSelectionList.setSelection(new String[]{"Default"});
        updateDetails(null);
        container.pack();
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