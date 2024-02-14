package cn.nuturbo.common.vo;

import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by penghs at 2024/2/14 6:21
 */
@Getter
public class Response<T> {

    private final Code code;
    private final String detailMessage;
    private final T data;

    @JsonCreator
    public Response(@JsonProperty("code") Code code, @JsonProperty("detailMessage") String detailMessage, @JsonProperty("data") T data) {
        this.code = Asserts.notNull(code, "code of response can not be null");
        this.detailMessage = detailMessage;
        this.data = data;
    }

    public Response(Code code, String detailMessage) {
        this(code, detailMessage, null);
    }

    public Response(Code code) {
        this(code, code.message, null);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(Code.SUCCESS, Code.SUCCESS.message, data);
    }

    public static <T> Response<T> success() {
        return new Response<>(Code.SUCCESS, Code.SUCCESS.message);
    }

    public static <T> Response<T> fail(String detailMessage) {
        return new Response<>(Code.FAIL, detailMessage);
    }

    public static <T> Response<T> error(String detailMessage) {
        return new Response<>(Code.ERROR, detailMessage);
    }

    @Getter
    public enum Code {
        SUCCESS(0, "success"),
        FAIL(1, "fail"),
        ERROR(2, "error");

        private final int code;
        private final String message;

        Code(int code, String message) {
            this.code = code;
            this.message = message;
        }

    }

}
