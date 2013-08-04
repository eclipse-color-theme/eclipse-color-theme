package com.github.eclipsecolortheme.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.github.eclipsecolortheme.Activator;

/** Initialises this plugin's preferences. */
public class PreferenceInitializer extends AbstractPreferenceInitializer {
    @Override
    public void initializeDefaultPreferences() {
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        store.setDefault("colorTheme", "default");
        store.setDefault("forceDefaultBG", false);
    }
}
