package com.jake.webstore.common.api.utils.enums;


import lombok.Getter;

@Getter
public enum ResultType {

    SUCCESS(200, "success");

    ResultType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;
    private final String message;
}
