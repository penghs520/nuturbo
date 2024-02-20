package cn.nuturbo.gateway.security;

import cn.nuturbo.gateway.entity.vo.request.AskCodeRequest;
import cn.nuturbo.gateway.utils.Const;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by penghs at 2024/2/17 15:04
 */
@Component
public class AccountService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        UserDetails userDetails = getUserInMemory(username);

        if (userDetails == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        //填充用户的权限信息

        return userDetails;
    }


    private UserDetails getUserInMemory(String username) {
        return User.withUsername(username)
                //123456的bcrypt加密
                .password("$2a$05$mnM9IC.FgS9tOGaYNFOMP.d1v8Lh8wT16MUOllpN66mQjySkvRrI.")
                .authorities("USER")
                .build();
    }

    public void registerEmailVerifyCode(AskCodeRequest askCodeRequest, String address) {
        synchronized (address.intern()) {
            /*if(!this.verifyLimit(address))
                return "请求频繁，请稍后再试";*/
            Random random = new Random();
            int code = random.nextInt(899999) + 100000;
            Map<String, Object> data = Map.of("type", askCodeRequest.type(), "email", askCodeRequest.email(), "code", code);
            //TODO 发送消息，使用消息中间件异步发送短信
            //rabbitTemplate.convertAndSend(Const.MQ_MAIL, data);
            //写入redis，有效时间5分钟，但1分钟内同个账号不可以重复发送，所以要写入redis两次
            //stringRedisTemplate.opsForValue()
            //.set(Const.VERIFY_EMAIL_DATA + askCodeRequest.email(), String.valueOf(code), 5, TimeUnit.MINUTES);
        }
    }
}
