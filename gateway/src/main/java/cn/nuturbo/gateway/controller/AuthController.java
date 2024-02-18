package cn.nuturbo.gateway.controller;

import cn.nuturbo.common.vo.Result;
import cn.nuturbo.gateway.domain.User;
import cn.nuturbo.gateway.request.LoginRequest;
import cn.nuturbo.gateway.service.login.LoginService;
import cn.nuturbo.gateway.utils.JwtUtil;
import cn.nuturbo.gateway.vo.LoginResult;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by penghs at 2024/2/18 14:58
 */
@RestController
public class AuthController {


    private final LoginService loginService;

    public AuthController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = "/login")
    public Result<LoginResult> login(@RequestBody LoginRequest loginReq) {
        return loginService.login(loginReq);
    }
}