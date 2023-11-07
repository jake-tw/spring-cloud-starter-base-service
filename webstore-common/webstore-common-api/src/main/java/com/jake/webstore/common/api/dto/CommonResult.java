package com.jake.webstore.common.api.dto;

import com.jake.webstore.common.api.enums.ResultType;
import lombok.Getter;

@Getter
public class CommonResult<T extends BaseDto> {

    private CommonResult(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.data = null;
    }

    private CommonResult(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    private final boolean success;
    private final String message;
    private final T data;

    public static <T extends BaseDto> CommonResult<T> empty() {
        return new CommonResult<>(true, ResultType.SUCCESS.getMessage());
    }

    public static <T extends BaseDto> CommonResult<T> success(T data) {
        return new CommonResult<>(true, ResultType.SUCCESS.getMessage(), data);
    }

    public static <T extends BaseDto> CommonResult<T> error(ResultType type) {
        return new CommonResult<>(false, type.getMessage());
    }
}
