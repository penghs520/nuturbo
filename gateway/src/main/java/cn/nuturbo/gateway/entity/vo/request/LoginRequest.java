package cn.nuturbo.gateway.entity.vo.request;

import cn.nuturbo.common.utils.Asserts;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by penghs at 2024/2/18 8:59
 */
public record LoginRequest(String username, String password, String verifyCode) {

    @JsonCreator
    public LoginRequest(@JsonProperty("username") String username, @JsonProperty("password") String password, @JsonProperty("verifyCode") String verifyCode) {
        this.username = Asserts.notBlank(username, "username can not be blank.");
        this.password = Asserts.notBlank(password, "password can not be blank.");
        this.verifyCode = Asserts.notBlank(verifyCode, "verifyCode can not be blank.");
    }
}
