package com.github.eclipsecolortheme.mapper;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;

public class TexlipseEditorMapper extends GenericMapper {
    private class Mapping extends ColorThemeMapping {
        public Mapping(String pluginKey, String themeKey) {
            super(pluginKey, themeKey);
        }

        @Override
        public void putPreferences(IEclipsePreferences preferences,
                ColorThemeSetting setting) {
            preferences.put(pluginKey, setting.getColor().asRGB());
            if (pluginKey.endsWith("TexColor")) {
                String styleKey = pluginKey.replaceAll("Color", "Style");
                if (setting.isBoldEnabled() != null && setting.isBoldEnabled()) {
                    preferences.putInt(styleKey, 1);
                } else if (setting.isItalicEnabled() != null && setting.isItalicEnabled()) {
                    preferences.putInt(styleKey, 2);
                } else {
                    preferences.remove(styleKey);
                }
            }
        }
    }

    @Override
    protected ColorThemeMapping createMapping(String pluginKey, String themeKey) {
        return new Mapping(pluginKey, themeKey);
    }
}
