package com.greff.challenge.domain.enums;

public enum Gender {
    MALE("Masculine"),
    FEMALE("Feminine"),
    OTHER("Other");

    private final String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
