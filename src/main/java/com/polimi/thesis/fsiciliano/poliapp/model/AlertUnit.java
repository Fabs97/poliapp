package com.polimi.thesis.fsiciliano.poliapp.model;

public enum AlertUnit {
    MINUTES("minuti"),
    HOURS("ore"),
    DAYS("giorni"),
    WEEKS("settimane"),
    ;

    private final String unit;

    AlertUnit(final String s) {
        this.unit = s;
    }

    @Override
    public String toString() {
        return unit;
    }
}
