package cn.nuturbo.common.exception;

/**
 * Created by penghs at 2024/2/13 21:21
 */
public class EntityNotFoundException extends BizException {

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
