package com.github.eclipsecolortheme.mapper;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;

public class FlashBuilderEditorMapper extends GenericMapper {
    private class Mapping extends ColorThemeMapping {
        public Mapping(String pluginKey, String themeKey) {
            super(pluginKey, themeKey);
        }

        @Override
        public void putPreferences(IEclipsePreferences preferences,
                ColorThemeSetting setting) {
            String baseKey = pluginKey.replaceAll("Color", "");
            preferences.put(pluginKey, setting.getColor().asHex());
            if (setting.isBoldEnabled() != null)
                preferences.putBoolean(baseKey + "Bold", setting.isBoldEnabled());
            if (setting.isItalicEnabled() != null)
                preferences.putBoolean(baseKey + "Italic", setting.isItalicEnabled());
            if (setting.isUnderlineEnabled() != null)
                preferences.putBoolean(baseKey + "Underline", setting.isUnderlineEnabled());
            if (setting.isStrikethroughEnabled() != null)
                preferences.putBoolean(baseKey + "Strikethrough", setting.isStrikethroughEnabled());
        }

    }

    @Override
    protected ColorThemeMapping createMapping(String pluginKey, String themeKey) {
        return new Mapping(pluginKey, themeKey);
    }
}
