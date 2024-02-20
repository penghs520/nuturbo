package cn.nuturbo.gateway.utils;

import io.jsonwebtoken.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;

/**
 * Created by penghs at 2024/2/18 14:53
 */
@Component
public class JwtUtil {

    private static final String secret_key = "secretkey";
    private static final long token_expire_millis = 60 * 60 * 1000;

    private final SnowflakeIdGenerator snowflakeIdGenerator;
    private final JwtParser jwtParser;

    private static final String TOKEN_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";

    public JwtUtil(SnowflakeIdGenerator snowflakeIdGenerator) {
        this.snowflakeIdGenerator = snowflakeIdGenerator;
        this.jwtParser = Jwts.parser().setSigningKey(secret_key);
    }

    public String createToken(UserDetails userDetails) {
        Claims claims = Jwts.claims().setSubject(userDetails.getUsername());
        Date tokenExpireTime = new Date(System.currentTimeMillis() + token_expire_millis);
        return Jwts.builder()
                .setId(String.valueOf(snowflakeIdGenerator.nextId()))
                .setClaims(claims)
                .setExpiration(tokenExpireTime)
                .signWith(SignatureAlgorithm.HS256, secret_key)
                .compact();
    }

    private Claims parseJwtClaims(String token) {
        return jwtParser.parseClaimsJws(token).getBody();
    }

    public Claims resolveClaims(HttpServletRequest req) {
        try {
            String token = resolveToken(req);
            if (token != null) {
                return parseJwtClaims(token);
            }
            return null;
        } catch (ExpiredJwtException ex) {
            req.setAttribute("expired", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            req.setAttribute("invalid", ex.getMessage());
            throw ex;
        }
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(TOKEN_HEADER);
        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    public boolean invalidateJwt(HttpServletRequest request) {
        String token = resolveToken(request);
        if (token != null) {
            //TODO 加入黑名单
            return true;
        }
        return false;
    }

    public boolean validateToken(Claims claims) throws AuthenticationException {
        try {
            //TODO 并且不再黑名单中
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            throw e;
        }
    }

    public UserDetails toUserDetails(Claims claims) {
        return User
                .withUsername(claims.get("name", String.class))
                .authorities(claims.get("authorities", Collection.class))
                .build();
    }
}