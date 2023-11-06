package com.jake.webstore.utils.enums;

import lombok.Getter;

@Getter
public enum ErrorType {

    TEMP(10001, "temp.message");

    ErrorType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;
    private final String message;
}
