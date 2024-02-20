package cn.nuturbo.gateway.entity.vo.response;

import cn.nuturbo.common.utils.Asserts;
import lombok.Getter;

/**
 * Created by penghs at 2024/2/18 8:54
 */
public record LoginResult(String token) {

    public LoginResult(String token) {
        this.token = Asserts.notNull(token, "token can not be null.");
    }
}
