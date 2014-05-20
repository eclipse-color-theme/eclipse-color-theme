package com.github.eclipsecolortheme.mapper;

import static java.lang.Boolean.TRUE;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.swt.SWT;

import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;

public class JsonToolsEditorMapper extends GenericMapper {
    private static class Mapping extends ColorThemeMapping {
        private static final int STYLE_VALUE_UNDERLINE = 0x40000000;
        private static final int STYLE_VALUE_STRIKETHROUGH = 0x20000000;

        public Mapping(String pluginKey, String themeKey) {
            super(pluginKey, themeKey);
        }

        @Override
        public void putPreferences(IEclipsePreferences preferences, ColorThemeSetting setting) {
            // Set the color itself
            super.putPreferences(preferences, setting);

            // Enables the color setting
            preferences.putBoolean(pluginKey + "Enabled", true);

            // Set style
            preferences.putInt(pluginKey + "Style", getStyleValue(setting));
        }

        private int getStyleValue(ColorThemeSetting setting) {
            final boolean bold = TRUE.equals(setting.isBoldEnabled());
            final boolean italic = TRUE.equals(setting.isItalicEnabled());
            final boolean underline = TRUE.equals(setting.isUnderlineEnabled());
            final boolean strikethrough = TRUE.equals(setting.isStrikethroughEnabled());

            int style = SWT.NORMAL;

            style |= bold ? SWT.BOLD : 0;
            style |= italic ? SWT.ITALIC : 0;
            style |= underline ? STYLE_VALUE_UNDERLINE : 0;
            style |= strikethrough ? STYLE_VALUE_STRIKETHROUGH : 0;

            return style;
        }
    }

    @Override
    protected ColorThemeMapping createMapping(String pluginKey, String themeKey) {
        return new Mapping(pluginKey, themeKey);
    }
}
