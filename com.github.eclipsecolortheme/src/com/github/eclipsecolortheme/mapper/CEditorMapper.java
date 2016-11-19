package com.github.eclipsecolortheme.mapper;

import java.util.Map;

import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;

public class CEditorMapper extends GenericMapper {
    private final String SOURCE_HOVER_BACKGROUND_COLOR_SYSTEM_DEFAULT_ID = "sourceHoverBackgroundColor.SystemDefault";

    @Override
    public void map(Map<String, ColorThemeSetting> theme, Map<String, ColorThemeMapping> overrideMappings) {
        preferences.putBoolean(SOURCE_HOVER_BACKGROUND_COLOR_SYSTEM_DEFAULT_ID, false);
        super.map(theme, overrideMappings);
    }

    @Override
    public void clear() {
        preferences.remove(SOURCE_HOVER_BACKGROUND_COLOR_SYSTEM_DEFAULT_ID);
        super.clear();
    }
}
