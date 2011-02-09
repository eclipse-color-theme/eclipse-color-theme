package com.github.eclipsecolortheme.test;

import junit.framework.Assert;

import org.junit.Test;

import com.github.eclipsecolortheme.Color;

public class ColorTest {

	@Test
	public void color() {
		Color color = new Color("#FFAA00");
		Assert.assertEquals("255,170,0", color.asRGB());
		Assert.assertEquals("#FFAA00", color.asHex().toUpperCase());
		Assert.assertEquals(255, color.getR().intValue());
		Assert.assertEquals(170, color.getG().intValue());
		Assert.assertEquals(0, color.getB().intValue());
	}

}
