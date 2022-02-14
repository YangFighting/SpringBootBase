package com.yang.springbootbase;

import com.yang.springbootbase.bean.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringbootbaseApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(person);
        System.out.println(person);
    }

    @Test
    void testHelloService(){
        boolean containsBean = ioc.containsBean("helloService");
        System.out.println("containsBean: " + containsBean);

    }

}
