package com.github.eclipsecolortheme.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.github.eclipsecolortheme.ColorTheme;
import com.github.eclipsecolortheme.ColorThemeSetting;

public class ColorThemeTest {
    private ColorTheme colorTheme;

    @Before
    public void setUp() {
        colorTheme = new ColorTheme();
    }

    @Test
    public void initialValues() {
        assertThat(colorTheme.getId(), nullValue());
        assertThat(colorTheme.getName(), nullValue());
        assertThat(colorTheme.getAuthor(), nullValue());
        assertThat(colorTheme.getWebsite(), nullValue());
        assertThat(colorTheme.getEntries(), nullValue());
    }

    @Test
    public void id() {
        colorTheme.setId("id");
        assertThat(colorTheme.getId(), is("id"));
    }

    @Test
    public void name() {
        colorTheme.setName("name");
        assertThat(colorTheme.getName(), is("name"));
    }

    @Test
    public void author() {
        colorTheme.setAuthor("author");
        assertThat(colorTheme.getAuthor(), is("author"));
    }

    @Test
    public void website() {
        colorTheme.setWebsite("website");
        assertThat(colorTheme.getWebsite(), is("website"));
    }

    @Test
    public void entries() {
        Map<String, ColorThemeSetting> entries = new HashMap<String, ColorThemeSetting>();
        colorTheme.setEntries(entries);
        assertThat(colorTheme.getEntries(), sameInstance(entries));
    }
}
