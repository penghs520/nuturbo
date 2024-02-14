package cn.nuturbo.card;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by penghs at 2024/2/14 16:47
 */
@SpringBootApplication
@EnableDubbo
public class CardApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(CardApplicationStarter.class, args);
    }
}
