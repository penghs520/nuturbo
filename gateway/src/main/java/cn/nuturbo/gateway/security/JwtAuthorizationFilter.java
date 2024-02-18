package cn.nuturbo.gateway.security;

import cn.nuturbo.common.utils.ObjectMapperUtil;
import cn.nuturbo.common.vo.Result;
import cn.nuturbo.gateway.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by penghs at 2024/2/18 22:23
 */
@Component
@Slf4j
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthorizationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = jwtUtil.resolveToken(request);
            if (token == null) {
                filterChain.doFilter(request, response);
                return;
            }
            log.info("token: {}", token);
            Claims claims = jwtUtil.resolveClaims(request);
            if (claims != null & jwtUtil.validateClaims(claims)) {
                String subject = claims.getSubject();
                log.info("claim's subject: {}", subject);
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(subject, "", new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            ObjectMapperUtil.getObjectMapper().writeValue(response.getWriter(), Result.fail("Authentication Error"));
        }
        filterChain.doFilter(request, response);
    }
}
