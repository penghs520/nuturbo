package cn.nuturbo.gateway.controller;

import cn.nuturbo.common.vo.Result;
import cn.nuturbo.gateway.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by penghs at 2024/2/17 16:13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/register")
    public Result<User> register() {
        return null;
    }

    @PostMapping("invite")
    public Result<User> invite() {
        return null;
    }

    @PostMapping("/login")
    public Result<User> login() {
        return null;
    }

    @PostMapping("/logout")
    public Result<User> logout() {
        return null;
    }

    @PostMapping("/info")
    public Result<User> info() {
        return null;
    }

    @PostMapping("/update")
    public Result<User> update() {
        return null;
    }

}
