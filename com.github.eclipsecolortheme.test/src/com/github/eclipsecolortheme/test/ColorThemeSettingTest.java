package com.github.eclipsecolortheme.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.eclipsecolortheme.Color;
import com.github.eclipsecolortheme.ColorThemeSetting;

public class ColorThemeSettingTest {

	@Test
	public void colorThemeSetting() {
		ColorThemeSetting setting = new ColorThemeSetting("#00FFAA");
		assertNull(setting.isBoldEnabled());
		assertNull(setting.isItalicEnabled());
		assertNull(setting.isStrikethroughEnabled());
		assertNull(setting.isUnderlineEnabled());
		Color color = setting.getColor();
		assertNotNull(color);
		assertEquals("#00FFAA", color.asHex());
	}
	
	@Test
	public void decorationBold() {
		ColorThemeSetting setting = new ColorThemeSetting("#00FFAA");
		setting.setBoldEnabled(true);
		assertTrue(setting.isBoldEnabled());
		setting.setBoldEnabled(false);
		assertFalse(setting.isBoldEnabled());
	}
	
	@Test
	public void decorationItalic() {
		ColorThemeSetting setting = new ColorThemeSetting("#00FFAA");
		setting.setBoldEnabled(true);
		assertTrue(setting.isBoldEnabled());
		setting.setBoldEnabled(false);
		assertFalse(setting.isBoldEnabled());
	}
	
	@Test
	public void decorationUnderline() {
		ColorThemeSetting setting = new ColorThemeSetting("#00FFAA");
		setting.setBoldEnabled(true);
		assertTrue(setting.isBoldEnabled());
		setting.setBoldEnabled(false);
		assertFalse(setting.isBoldEnabled());
	}
	
	@Test
	public void decorationStrikethrough() {
		ColorThemeSetting setting = new ColorThemeSetting("#00FFAA");
		setting.setStrikethroughEnabled(true);
		assertTrue(setting.isStrikethroughEnabled());
		setting.setStrikethroughEnabled(false);
		assertFalse(setting.isStrikethroughEnabled());
	}

}
