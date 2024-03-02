package io.shyftlabs.entity;

public enum Score {
    A,
    B,
    C,
    D,
    E,
    F;


    public static Score value(String score) {
        if (score == null) {
            return null;
        }
        return valueOf(score.toUpperCase());
    }
}
