package com.github.fhd.eclipsecolortheme.preferences;

import org.eclipse.core.runtime.preferences.*;
import org.eclipse.jface.preference.*;

import com.github.fhd.eclipsecolortheme.*;

/** Initialises this plugin's preferences. */
public class PreferenceInitializer extends AbstractPreferenceInitializer {
    @Override
    public void initializeDefaultPreferences() {
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        store.setDefault("colorTheme", "default");
    }
}
