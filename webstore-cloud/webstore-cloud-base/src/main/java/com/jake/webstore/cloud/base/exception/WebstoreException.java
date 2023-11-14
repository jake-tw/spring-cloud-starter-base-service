package com.jake.webstore.cloud.base.exception;

import com.jake.webstore.cloud.base.enums.ResultType;
import lombok.Getter;


@Getter
public class WebstoreException extends RuntimeException {
    private final ResultType type;

    public WebstoreException(ResultType type) {
        super(type.getMessage());
        this.type = type;
    }
}
