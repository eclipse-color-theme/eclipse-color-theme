package com.github.eclipsecolortheme.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;
import com.github.eclipsecolortheme.test.mock.MockEclipsePreferences;

public class ColorThemeMappingTest {

	@Test
	public void colorThemeMapping() {
		ColorThemeMapping mapping = new ColorThemeMapping("org.eclipse.php.ui.color", "foreground");
		assertEquals("foreground", mapping.getThemeKey());
	}

	@Test
	public void putPreferences() {
		MockEclipsePreferences preferences = new MockEclipsePreferences();
		ColorThemeSetting setting = new ColorThemeSetting("#336699");
		ColorThemeMapping mapping = new ColorThemeMapping("org.eclipse.php.ui.color", "foreground");
		mapping.putPreferences(preferences, setting);
		assertEquals("51,102,153", preferences.get("org.eclipse.php.ui.color", null));
	}

	@Test
	public void removePreferences() {
		MockEclipsePreferences preferences = new MockEclipsePreferences();
		ColorThemeSetting setting = new ColorThemeSetting("#336699");
		ColorThemeMapping mapping = new ColorThemeMapping("org.eclipse.php.ui.color", "foreground");
		mapping.putPreferences(preferences, setting);
		mapping.removePreferences(preferences);
		assertNull(preferences.get("org.eclipse.php.ui.color", null));
	}

}
