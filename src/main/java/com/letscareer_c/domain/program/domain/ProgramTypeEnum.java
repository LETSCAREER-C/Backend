package com.letscareer_c.domain.program.domain;

public enum ProgramTypeEnum {
    CHALLENGE("CHALLENGE"),
    LIVECLASS("LIVECLASS");

    private final String value;

    ProgramTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
