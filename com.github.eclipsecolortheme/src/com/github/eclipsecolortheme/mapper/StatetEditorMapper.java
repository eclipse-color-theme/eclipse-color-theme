package com.github.eclipsecolortheme.mapper;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;

public class StatetEditorMapper extends GenericMapper {
    private class Mapping extends ColorThemeMapping {
        public Mapping(String pluginKey, String themeKey) {
            super(pluginKey, themeKey);
        }

        @Override
        public void putPreferences(IEclipsePreferences preferences,
                ColorThemeSetting setting) {
            preferences.put(pluginKey, setting.getColor().asRGB());
            if (setting.isBoldEnabled() != null)
                preferences.putBoolean(pluginKey.replaceAll(".color", ".bold"), setting.isBoldEnabled());
            if (setting.isItalicEnabled() != null)
                preferences.putBoolean(pluginKey.replaceAll(".color", ".italic"), setting.isItalicEnabled());
            if (setting.isStrikethroughEnabled() != null)
                preferences.putBoolean(pluginKey.replaceAll(".color", ".strikethrough"), setting.isStrikethroughEnabled());
            if (setting.isUnderlineEnabled() != null)
                preferences.putBoolean(pluginKey.replaceAll(".color", ".underline"), setting.isUnderlineEnabled());
        }
    }

    @Override
    protected ColorThemeMapping createMapping(String pluginKey, String themeKey) {
        return new Mapping(pluginKey, themeKey);
    }
}
