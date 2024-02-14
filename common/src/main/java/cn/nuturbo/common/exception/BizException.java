package cn.nuturbo.common.exception;

/**
 * Created by penghs at 2024/2/13 21:20
 */
public abstract class BizException extends RuntimeException {

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }
}
