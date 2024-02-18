package cn.nuturbo.gateway.config;

import cn.nuturbo.gateway.filter.CustomAuthenticationFilter;
import cn.nuturbo.gateway.service.login.LoginUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by penghs at 2024/2/18 8:05
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final LoginUserDetailsService loginUserDetailsService;

    public WebSecurityConfig(LoginUserDetailsService loginUserDetailsService) {
        this.loginUserDetailsService = loginUserDetailsService;
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
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//前后端分离项目不需要session
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(LoginUserDetailsService userDetailsService) {
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //@Bean
   /* public CustomizedLoginFilter customizedLoginFilter() throws Exception {
        CustomizedLoginFilter customizedLoginFilter = new CustomizedLoginFilter(authenticationConfiguration);
        customizedLoginFilter.setAuthenticationSuccessHandler((request, response, authentication) -> {
            response.getWriter().write("login success");
        });
        customizedLoginFilter.setAuthenticationFailureHandler((request, response, exception) -> {
            response.getWriter().write("login failure");
        });
        return customizedLoginFilter;
    }*/
}
