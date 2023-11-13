package com.jake.webstore.cloud.base.dto;

import com.jake.webstore.cloud.base.enums.ResultType;
import lombok.Getter;

@Getter
public class CommonResult<T extends Record> {

    private CommonResult(boolean success, ResultType type) {
        this.success = success;
        this.code = type.getCode();
        this.message = type.getMessage();
        this.data = null;
    }

    private CommonResult(boolean success, ResultType type, T data) {
        this.success = success;
        this.code = type.getCode();
        this.message = type.getMessage();
        this.data = data;
    }

    private final boolean success;
    private final int code;
    private final String message;
    private final T data;

    public static <T extends Record> CommonResult<T> empty() {
        return new CommonResult<>(true, ResultType.SUCCESS);
    }

    public static <T extends Record> CommonResult<T> success(T data) {
        return new CommonResult<>(true, ResultType.SUCCESS, data);
    }

    public static <T extends Record> CommonResult<T> failed(ResultType type) {
        return new CommonResult<>(false, type);
    }
}
