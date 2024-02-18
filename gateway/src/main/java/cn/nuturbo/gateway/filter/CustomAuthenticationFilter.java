package cn.nuturbo.gateway.filter;

import cn.nuturbo.common.utils.ObjectMapperUtil;
import cn.nuturbo.gateway.request.LoginRequest;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by penghs at 2024/2/18 12:46
 */
//@Component
@Deprecated(since = "2024-02-18", forRemoval = true)
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationConfiguration authenticationConfiguration;

    public CustomAuthenticationFilter(AuthenticationConfiguration authenticationConfiguration) {
        this.authenticationConfiguration = authenticationConfiguration;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        LoginRequest loginRequest = obtainLoginRequest(request);
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                loginRequest.username(), loginRequest.password());
        try {
            return authenticationConfiguration.getAuthenticationManager().authenticate(authRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private LoginRequest obtainLoginRequest(HttpServletRequest request) {
        try {
            BufferedReader reader = request.getReader();
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            if (sb.isEmpty()) {
                throw new RuntimeException("request body is empty");
            }
            return new ObjectMapperUtil().readValue(sb.toString(), LoginRequest.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
