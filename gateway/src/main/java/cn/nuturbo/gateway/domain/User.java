package cn.nuturbo.gateway.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by penghs at 2024/2/17 15:10
 */
@Setter
@Getter
public class User {

    private String username;
    private String password;
    private boolean accountLocked = false;

}
