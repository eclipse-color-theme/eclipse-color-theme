package com.github.eclipsecolortheme.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.github.eclipsecolortheme.ColorThemeMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;
import com.github.eclipsecolortheme.test.mock.MockEclipsePreferences;

public class ColorThemeMappingTest {
    private ColorThemeMapping mapping;

    @Before
    public void setUp() {
        mapping = new ColorThemeMapping("org.eclipse.php.ui.color", "foreground");
    }

    @Test
    public void putPreferences() {
        MockEclipsePreferences preferences = new MockEclipsePreferences();
        ColorThemeSetting setting = new ColorThemeSetting("#336699");
        mapping.putPreferences(preferences, setting);
        assertThat(preferences.get("org.eclipse.php.ui.color", null), is("51,102,153"));
    }

    @Test
    public void removePreferences() {
        MockEclipsePreferences preferences = new MockEclipsePreferences();
        mapping.putPreferences(preferences, new ColorThemeSetting("#336699"));
        mapping.removePreferences(preferences);
        assertThat(preferences.get("org.eclipse.php.ui.color", null), nullValue());
    }

    @Test
    public void getThemeKey() {
        assertThat((String) mapping.getThemeKey(), is("foreground"));
    }
}
