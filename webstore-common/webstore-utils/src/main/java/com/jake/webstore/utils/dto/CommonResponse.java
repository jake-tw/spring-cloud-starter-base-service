package com.jake.webstore.utils.dto;

import com.jake.webstore.utils.enums.ErrorType;
import com.jake.webstore.utils.enums.ResultType;
import lombok.Data;

@Data
public class CommonResponse<T> {

    private CommonResponse(ResultType type) {
        this.code = type.getCode();
        this.message = type.getMessage();
    }

    private CommonResponse(ResultType type, T data) {
        this.code = type.getCode();
        this.message = type.getMessage();
        this.data = data;
    }

    private CommonResponse(ErrorType type) {
        this.code = type.getCode();
        this.message = type.getMessage();
    }

    private int code;
    private String message;
    private T data;

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(ResultType.SUCCESS, data);
    }


    public static <T> CommonResponse<T> error(ErrorType type) {
        return new CommonResponse<>(type);
    }

    public static <T> CommonResponse<T> of(ResultType type) {
        return new CommonResponse<>(type);
    }
}
