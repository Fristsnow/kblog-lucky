package com.lucky.kblog.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一返回
 *
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    /**
     * 重写返回
     *
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> returnDate(int code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * success not data
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> success() {
        return returnDate(ResultC.SUCCESS, ResultC.MSG_SUCCESS, null);
    }

    /**
     * success return data
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data) {
        return returnDate(ResultC.SUCCESS, ResultC.MSG_SUCCESS, data);
    }

    /**
     * error -> 404
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> error404() {
        return returnDate(ResultC.NotFound, ResultC.MSG_NOTFOUND, null);
    }

    /**
     * 认证失败 -> 401
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> error401() {
        return returnDate(ResultC.UNAUTHORIZED, ResultC.MSG_UNAUTHORIZED, null);
    }

    /**
     * error -> 422
     * @param msg
     * @return
     * @param <T>
     */
    public static <T> Result<T> error422(String msg) {
        return returnDate(422, msg, null);
    }

    /**
     * error -> 自定义错误
     *
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(int code, String msg) {
        return returnDate(code, msg, null);
    }
}
