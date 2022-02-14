package com.yang.springbootbase.config;

import com.yang.springbootbase.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public HelloService helloService(){
        System.out.println(" helloService add...");
        return new HelloService();
    }
}
