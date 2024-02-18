package cn.nuturbo.gateway.security;

import cn.nuturbo.common.vo.Result;
import cn.nuturbo.gateway.domain.LoginUser;
import cn.nuturbo.gateway.domain.User;
import cn.nuturbo.gateway.request.LoginRequest;
import cn.nuturbo.gateway.utils.JwtUtil;
import cn.nuturbo.gateway.vo.LoginResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Created by penghs at 2024/2/18 21:50
 */
@Service
@Slf4j
public class LoginService {

    private final AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    public LoginService(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public Result<LoginResult> login(LoginRequest loginRequest) {
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            if (authentication instanceof UsernamePasswordAuthenticationToken up && authentication.isAuthenticated()) {
                LoginUser loginUser = (LoginUser) up.getPrincipal();
                User user = loginUser.getUser();
                user.setPassword(null);
                String token = jwtUtil.createToken(user);
                return Result.success(new LoginResult(token));
            }
        } catch (Exception e) {
            log.error("login failed", e);
        }
        return Result.fail("登录失败");
    }
}
