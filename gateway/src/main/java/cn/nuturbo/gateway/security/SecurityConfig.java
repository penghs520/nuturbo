package cn.nuturbo.gateway.security;

import cn.nuturbo.common.vo.Result;
import cn.nuturbo.gateway.utils.JwtUtil;
import cn.nuturbo.gateway.entity.vo.response.LoginResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by penghs at 2024/2/18 8:05
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final AccountService loginUserDetailsService;
    private final JwtAuthorizationFilter jwtAuthorizationFilter;
    private final RequestLogFilter requestLogFilter;
    private final JwtUtil jwtUtil;

    public SecurityConfig(AccountService loginUserDetailsService, JwtAuthorizationFilter jwtAuthorizationFilter, RequestLogFilter requestLogFilter, JwtUtil jwtUtil) {
        this.loginUserDetailsService = loginUserDetailsService;
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
        this.requestLogFilter = requestLogFilter;
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder)
            throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(loginUserDetailsService).passwordEncoder(passwordEncoder);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(conf -> conf
                        .antMatchers("/api/auth/**", "/error").permitAll()
                        //.antMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        //.anyRequest().hasAnyRole(Const.ROLE_DEFAULT)
                        .anyRequest().authenticated()
                )
                .formLogin(conf -> conf
                        .loginProcessingUrl("/api/auth/login")
                        .failureHandler(this::failureHandle)
                        .successHandler(this::successHandle)
                )
                .logout(conf -> conf
                        .logoutUrl("/api/auth/logout")
                        .logoutSuccessHandler(this::onLogoutSuccess)
                )
                .exceptionHandling(conf -> conf
                        .accessDeniedHandler(this::accessDeniedHandler)
                        .authenticationEntryPoint(this::authenticationEntryPoint)
                )
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(conf -> conf
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(requestLogFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthorizationFilter, RequestLogFilter.class)
                .build();
    }

    private void authenticationEntryPoint(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Result<?> result = Result.fail("请登录后操作");
        writer.write(result.toJsonString());
    }

    private void successHandle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        UserDetails user = (UserDetails) authentication.getPrincipal();
        String token = jwtUtil.createToken(user);
        Result<LoginResult> result = Result.success(new LoginResult(token));
        writer.write(result.toJsonString());
    }

    private void accessDeniedHandler(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Result<?> result = Result.fail("权限不足");
        writer.write(result.toJsonString());
    }

    private void failureHandle(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Result<?> result = Result.fail("登录失败");
        writer.write(result.toJsonString());
    }

    private void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (jwtUtil.invalidateJwt(request)) {
            writer.write(Result.success("退出登录成功").toJsonString());
        } else {
            writer.write(Result.fail("退出登录失败").toJsonString());
        }
    }

    @Bean
    public UserDetailsService userDetailsService(AccountService userDetailsService) {
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
