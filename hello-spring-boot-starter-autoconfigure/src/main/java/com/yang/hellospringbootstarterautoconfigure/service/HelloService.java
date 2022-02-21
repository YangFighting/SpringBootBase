package com.yang.hellospringbootstarterautoconfigure.service;

import com.yang.hellospringbootstarterautoconfigure.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 默认不要放在容器中
 */
public class HelloService {

    @Autowired
    private HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public String sayHello(String userName){
        return helloProperties.getPrefix() + ": " + userName + " > " + helloProperties.getSuffix();
    }
}
