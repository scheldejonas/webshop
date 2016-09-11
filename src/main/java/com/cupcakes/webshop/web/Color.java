package com.cupcakes.webshop.web;

/**
 * Created by scheldejonas on 10/09/16.
 */
public enum Color {
    AQUA("Aqua","#59b3b3"),
    BLUE("Blue","#5976b3"),
    PURPLE("Purple","#7e59b3"),
    FUCHSIA("Fucshia","#b35986"),
    ORANGE("Orange","#b36859"),
    GOLD("Gold","#b38f59");

    private final java.lang.String name;
    private final java.lang.String hexCode;

    Color(java.lang.String name, java.lang.String hexCode) {
        this.name = name;
        this.hexCode = hexCode;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.String getHexCode() {
        return hexCode;
    }
}
