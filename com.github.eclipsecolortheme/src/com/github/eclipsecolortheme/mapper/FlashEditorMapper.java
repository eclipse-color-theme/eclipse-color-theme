package com.github.eclipsecolortheme.mapper;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSemanticHighlightingMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;

public class FlashEditorMapper extends GenericMapper {
    private class Mapping extends ColorThemeMapping {
        public Mapping(String pluginKey, String themeKey) {
            super(pluginKey, themeKey);
        }

        @Override
        public void putPreferences(IEclipsePreferences preferences,
                ColorThemeSetting setting) {
            preferences.put(pluginKey, setting.getColor().asRGB());
            if (setting.isBoldEnabled() != null)
                preferences.putBoolean(pluginKey + "_bold", setting.isBoldEnabled());
            if (setting.isItalicEnabled() != null)
                preferences.putBoolean(pluginKey + "_italic", setting.isItalicEnabled());
            if (setting.isStrikethroughEnabled() != null)
                preferences.putBoolean(pluginKey + "_strikethrough", setting.isStrikethroughEnabled());
            if (setting.isUnderlineEnabled() != null)
                preferences.putBoolean(pluginKey + "_underline", setting.isUnderlineEnabled());
        }
    }

    private class SemanticMapping extends ColorThemeSemanticHighlightingMapping {
        public SemanticMapping(String pluginKey, String themeKey) {
            super(pluginKey, themeKey);
            setSeparator("_");
        }
    }

    @Override
    protected ColorThemeMapping createMapping(String pluginKey, String themeKey) {
        return new Mapping(pluginKey, themeKey);
    }

    @Override
    protected ColorThemeSemanticHighlightingMapping createSemanticHighlightingMapping(
            String pluginKey, String themeKey) {
        return new SemanticMapping(pluginKey, themeKey);
    }
}
