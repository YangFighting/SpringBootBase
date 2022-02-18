package com.yang.hellospringbootstartertest;


import com.yang.hellospringbootstarterautoconfigure.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloSpringBootStarterTestApplicationTests {

    @Autowired
    private HelloService helloService11;

    @Test
    void contextLoads() {
        System.out.println(helloService11.sayHello("yang"));
        Assertions.assertEquals("hello: yang > 666", helloService11.sayHello("yang"));
    }

}
