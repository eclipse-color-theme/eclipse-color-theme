package com.github.eclipsecolortheme;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

public class ColorThemeSemanticHighlightingMapping extends ColorThemeMapping {
    protected String separator = ".";

    public ColorThemeSemanticHighlightingMapping(String pluginKey,
            String themeKey) {
        super(pluginKey, themeKey);
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    @Override
    public void putPreferences(IEclipsePreferences preferences,
            ColorThemeSetting setting) {
        preferences.putBoolean(pluginKey + separator + "enabled", true);
        preferences.put(pluginKey + separator + "color", setting.getColor().asRGB());
        if (setting.isBoldEnabled() != null)
            preferences.putBoolean(pluginKey + separator + "bold", setting.isBoldEnabled());
        if (setting.isItalicEnabled() != null)
            preferences.putBoolean(pluginKey + separator + "italic", setting.isItalicEnabled());
        if (setting.isUnderlineEnabled() != null)
            preferences.putBoolean(pluginKey + separator + "underline", setting.isUnderlineEnabled());
        if (setting.isStrikethroughEnabled() != null)
            preferences.putBoolean(pluginKey + separator + "strikethrough", setting.isStrikethroughEnabled());
    }

    public void removePreferences(IEclipsePreferences preferences) {
        preferences.remove(pluginKey + separator + "enabled");
        preferences.remove(pluginKey + separator + "color");
        preferences.remove(pluginKey + separator + "bold");
        preferences.remove(pluginKey + separator + "italic");
        preferences.remove(pluginKey + separator + "underline");
        preferences.remove(pluginKey + separator + "strikethrough");
    }
}
