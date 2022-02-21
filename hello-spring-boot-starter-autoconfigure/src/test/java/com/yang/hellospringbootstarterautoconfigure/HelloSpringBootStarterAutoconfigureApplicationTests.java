package com.yang.hellospringbootstarterautoconfigure;


import com.yang.hellospringbootstarterautoconfigure.bean.HelloProperties;
import com.yang.hellospringbootstarterautoconfigure.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloSpringBootStarterAutoconfigureApplicationTests {

    @Autowired
    private HelloService helloService;

    @Test
    void contextLoads() {
        HelloProperties helloProperties = helloService.getHelloProperties();
        System.out.println(helloService.sayHello("yang"));
        Assertions.assertEquals(helloProperties.getPrefix() + ": yang > " + helloProperties.getSuffix(), helloService.sayHello("yang"));
    }
}


