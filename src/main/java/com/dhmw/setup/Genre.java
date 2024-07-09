package com.dhmw.setup;

public enum Genre {

    DEEP_HOUSE("Deep House Music"),
    DUB("Dub Muisic"),
    TECHNO("Techno Music");

    private String definition;

    Genre(String definition) {
        this.definition = definition;
    }

    public String getValue() {
        return this.definition;
    }

}
