package com.github.eclipsecolortheme.mapper;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;

public class E4CSSMapper extends GenericMapper {
    private class Mapping extends ColorThemeMapping {
        private static final String KEY_PREFIX = "org.eclipse.e4.CSS.syntaxColorer.tokenStyles";
        public Mapping(String pluginKey, String themeKey) {
            super(pluginKey, themeKey);
        }

        @Override
        public void putPreferences(IEclipsePreferences preferences, ColorThemeSetting setting) {
            preferences.put(KEY_PREFIX + '.' + pluginKey + ".color", setting.getColor().asRGB());
            preferences.put(KEY_PREFIX + '.' + pluginKey + ".bgColor", defaultBackground.getHexColorOrEmpty());
        }
    }

    @Override
    protected ColorThemeMapping createMapping(String pluginKey, String themeKey) {
        return new Mapping(pluginKey, themeKey);
    }
}
