package cn.nuturbo.gateway.entity.vo.request;

import cn.nuturbo.common.utils.Asserts;

/**
 * Created by penghs at 2024/2/20 12:38
 */
public record AskCodeRequest(String email, Type type) {

    public AskCodeRequest(String email, Type type) {
        this.email = Asserts.notNull(email, "email can not be null");
        this.type = Asserts.notNull(type, "type can not be null");
    }

    public enum Type {
        REGISTER,
        RESET_PASSWORD
    }
}
