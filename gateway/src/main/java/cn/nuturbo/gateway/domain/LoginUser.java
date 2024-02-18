package cn.nuturbo.gateway.domain;

import cn.nuturbo.common.utils.Asserts;
import cn.nuturbo.gateway.domain.User;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

/**
 * Created by penghs at 2024/2/17 15:10
 */
@Setter
public class LoginUser implements UserDetails {

    private final User user;
    private List<GrantedAuthority> authorities;
    private int expireTime;

    public LoginUser(User user) {
        this.user = Asserts.notNull(user, "user can not be null.");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !user.isAccountLocked();
    }
}
