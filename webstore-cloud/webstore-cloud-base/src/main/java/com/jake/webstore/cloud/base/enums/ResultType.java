package com.jake.webstore.cloud.base.enums;


import lombok.Getter;

@Getter
public enum ResultType {

    // TODO optimize error code
    SUCCESS(200, "success"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    REQUEST_TIMEOUT(408, "Request Timeout"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    USER_EXISTS(10001, "message.user.exists"),
    USER_NOT_EXISTS(10002, "message.user.not.exists"),
    USER_LOGIN_ERROR(10003, "message.user.login.error"),
    ;

    ResultType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;
    private final String message;
}
