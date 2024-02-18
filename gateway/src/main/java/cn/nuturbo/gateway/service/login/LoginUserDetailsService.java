package cn.nuturbo.gateway.service.login;

import cn.nuturbo.gateway.domain.LoginUser;
import cn.nuturbo.gateway.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by penghs at 2024/2/17 15:04
 */
@Component
public class LoginUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        User user = getUserInMemory(username);

        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        LoginUser loginUser = new LoginUser(user, true);

        //填充用户的权限信息

        return loginUser;
    }


    private User getUserInMemory(String username) {
        User user = new User();
        user.setUsername(username);
        //123456的bcrypt加密
        user.setPassword("$2a$05$mnM9IC.FgS9tOGaYNFOMP.d1v8Lh8wT16MUOllpN66mQjySkvRrI.");
        return user;
    }
}
