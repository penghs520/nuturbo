package cn.nuturbo.gateway.controller;

import cn.nuturbo.common.vo.Result;
import cn.nuturbo.gateway.domain.User;
import cn.nuturbo.gateway.request.LoginRequest;
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

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping(value = "/login")
    public Result<LoginResult> login(@RequestBody LoginRequest loginReq) {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.username(), loginReq.password()));
            String username = authentication.getName();
            User user = new User();
            user.setUsername(username);
            String token = jwtUtil.createToken(user);
            return Result.success(new LoginResult(token));

        } catch (Exception e) {
            return Result.fail("login failed");
        }
    }
}