package com.github.eclipsecolortheme.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.github.eclipsecolortheme.ColorThemeSemanticHighlightingMapping;
import com.github.eclipsecolortheme.ColorThemeSetting;
import com.github.eclipsecolortheme.test.mock.MockEclipsePreferences;

public class ColorThemeSemanticHighlightingMappingTest {
    private ColorThemeSemanticHighlightingMapping mapping;
    private MockEclipsePreferences mockPreferences;
    private ColorThemeSetting setting;

    @Before
    public void setUp() {
        mapping = new ColorThemeSemanticHighlightingMapping("something", "foreground");
        mockPreferences = new MockEclipsePreferences();
        setting = new ColorThemeSetting("#336699");
    }

    @Test
    public void putPreferences() {
        mapping.putPreferences(mockPreferences, setting);
        assertThat(mockPreferences.getBoolean("something.enabled", false), is(true));
        assertThat(mockPreferences.get("something.color", null), is("51,102,153"));
    }

    @Test
    public void putPreferencesWithTextStyle() {
        setting.setBoldEnabled(true);
        setting.setItalicEnabled(true);
        setting.setUnderlineEnabled(true);
        setting.setStrikethroughEnabled(true);
        mapping.putPreferences(mockPreferences, setting);
        assertThat(mockPreferences.getBoolean("something.bold", false), is(true));
        assertThat(mockPreferences.getBoolean("something.italic", false), is(true));
        assertThat(mockPreferences.getBoolean("something.underline", false), is(true));
        assertThat(mockPreferences.getBoolean("something.strikethrough", false), is(true));
    }

    @Test
    public void removePreferences() {
        setting.setBoldEnabled(true);
        setting.setItalicEnabled(true);
        setting.setUnderlineEnabled(true);
        setting.setStrikethroughEnabled(true);
        mapping.putPreferences(mockPreferences, setting);
        mapping.removePreferences(mockPreferences);
        assertThat(mockPreferences.getBoolean("something.enabled", false), is(false));
        assertThat(mockPreferences.get("something.color", ""), is(""));
        assertThat(mockPreferences.getBoolean("something.bold", false), is(false));
        assertThat(mockPreferences.getBoolean("something.italic", false), is(false));
        assertThat(mockPreferences.getBoolean("something.underline", false), is(false));
        assertThat(mockPreferences.getBoolean("something.strikethrough", false), is(false));
    }
}
