package com.lialong.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.lialong.im")
@MapperScan(basePackages = {"com.lialong.im.dao"})
@EnableConfigurationProperties
public class ImApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImApplication.class, args);
    }

}
