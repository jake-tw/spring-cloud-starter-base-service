package com.jake.webstore.cloud.base.enums;


import lombok.Getter;

@Getter
public enum ResultType {

    SUCCESS(200, "success"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),


    USER_EXISTS(10001, "message.user.exists"),
    USER_NOT_EXISTS(10002, "message.user.not.exists");

    ResultType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;
    private final String message;
}
