package com.github.eclipsecolortheme.mapper;

import java.util.Map;

import com.github.eclipsecolortheme.ColorThemeSetting;

public class CEditorMapper extends GenericMapper {

	@Override
	public void map(Map<String, ColorThemeSetting> theme) {
		preferences.putBoolean("sourceHoverBackgroundColor.SystemDefault", false);
		super.map(theme);
	}
	
}
