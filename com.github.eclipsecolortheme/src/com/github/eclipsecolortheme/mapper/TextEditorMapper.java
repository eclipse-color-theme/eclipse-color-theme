package com.github.eclipsecolortheme.mapper;

import java.util.Map;

import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;

public class TextEditorMapper extends GenericMapper {
    @Override
    public void map(Map<String, ColorThemeSetting> theme, Map<String, ColorThemeMapping> overrideMappings) {
        preferences.putBoolean("AbstractTextEditor.Color.Background.SystemDefault", false);
        preferences.putBoolean("AbstractTextEditor.Color.Foreground.SystemDefault", false);
        preferences.putBoolean("AbstractTextEditor.Color.SelectionBackground.SystemDefault", false);
        preferences.putBoolean("AbstractTextEditor.Color.SelectionForeground.SystemDefault", false);
        super.map(theme, overrideMappings);
    }
}
