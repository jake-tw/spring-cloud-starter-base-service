package com.jake.webstore.utils.dto;

import com.jake.webstore.utils.enums.ResultType;
import lombok.Data;

@Data
public class CommonResult<T> {

    private CommonResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    private CommonResult(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    private boolean success;
    private String message;
    private T data;

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(true, ResultType.SUCCESS.getMessage(), data);
    }

    public static <T> CommonResult<T> error(ResultType type) {
        return new CommonResult<>(false, type.getMessage());
    }
}
