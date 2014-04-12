package com.github.eclipsecolortheme.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.github.eclipsecolortheme.Color;

public class ColorTest {
    private Color color;

    @Before
    public void setUp() {
        color = new Color("#FFAA00");
    }

    @Test
    public void rgbGetters() {
        assertThat(color.getR(), is(255));
        assertThat(color.getG(), is(170));
        assertThat(color.getB(), is(0));
    }

    @Test
    public void asHex() {
        assertThat(color.asHex().toUpperCase(), is("#FFAA00"));
    }

    @Test
    public void asRGB() {
        assertThat(color.asRGB(), is("255,170,0"));
    }
}
