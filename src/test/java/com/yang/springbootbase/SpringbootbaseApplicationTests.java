package com.yang.springbootbase;

import com.alibaba.druid.pool.DruidDataSource;
import com.yang.springbootbase.bean.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringbootbaseApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(person);
        System.out.println(person);

        logger.trace("---trace 日志---");
        logger.debug("--- debug 日志---");
        logger.info("--- info 日志---");
        logger.warn("--- warn 日志---");
        logger.error("--- error 日志---");
    }

    @Test
    void testHelloService(){
        boolean containsBean = ioc.containsBean("helloService");
        System.out.println("containsBean: " + containsBean);

    }

    @Test
    void testJdbc() throws SQLException {
        logger.info("dataSource: {}", dataSource.getClass().getName());
        Connection connection = dataSource.getConnection();
        logger.info("connection: {}", connection.toString());
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        logger.info("druidDataSource maxActive 数据源最大连接数: {}", druidDataSource.getMaxActive());
        logger.info("druidDataSource initialSize 数据源初始化连接数: {}", druidDataSource.getInitialSize());


    }

}
