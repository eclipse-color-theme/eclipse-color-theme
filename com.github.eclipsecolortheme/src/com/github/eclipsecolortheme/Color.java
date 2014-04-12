package com.github.eclipsecolortheme;

public class Color {
    private Integer r = new Integer(0);
    private Integer g = new Integer(0);
    private Integer b = new Integer(0);

    public Color(String value) {
        if (value != null) {
            if (value.startsWith("#")) {
                r = Integer.parseInt(value.substring(1, 3), 16);
                g = Integer.parseInt(value.substring(3, 5), 16);
                b = Integer.parseInt(value.substring(5, 7), 16);
            }
        }
    }

    public Integer getR() {
        return r;
    }

    public Integer getG() {
        return g;
    }

    public Integer getB() {
        return b;
    }

    public String asHex() {
        String hexr = Integer.toHexString(r).toUpperCase();
        String hexg = Integer.toHexString(g).toUpperCase();
        String hexb = Integer.toHexString(b).toUpperCase();
        return "#" + (hexr.length() == 2 ? hexr : "0" + hexr) + "" + (hexg.length() == 2 ? hexg : "0" + hexg) + "" + (hexb.length() == 2 ? hexb : "0" + hexb);
    }

    public String asRGB() {
        return r + "," + g + "," + b;
    }

    @Override
    public String toString() {
        return r + "," + g + "," + b;
    }
}
