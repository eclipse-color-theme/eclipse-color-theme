package com.github.eclipsecolortheme.mapper;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.osgi.service.prefs.Preferences;

import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;

public class StatetBaseEditorMapper extends GenericMapper {
    private class Mapping extends ColorThemeMapping {
        public Mapping(String pluginKey, String themeKey) {
            super(pluginKey, themeKey);
        }

        @Override
        public void putPreferences(IEclipsePreferences preferences,
                ColorThemeSetting setting) {
            if (pluginKey.startsWith("editors/options/")) {
                Preferences pref = preferences.parent().node("de.walware.statet.base.ui/editors/options");
                pref.put(pluginKey.substring(16), setting.getColor().asRGB());
            } else {
                preferences.put(pluginKey, setting.getColor().asRGB());
            }
        }

    }

    @Override
    protected ColorThemeMapping createMapping(String pluginKey, String themeKey) {
        return new Mapping(pluginKey, themeKey);
    }
}
