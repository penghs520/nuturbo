package cn.nuturbo.gateway;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by penghs at 2024/2/14 17:07
 */
@SpringBootApplication
@EnableDubbo
public class GatewayApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GatewayApplication.class, args);
        System.out.println("GatewayApplication started successfully!");
    }
}
