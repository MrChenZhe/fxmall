package com.qianfeng.fxmall.commons.mybatis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextUtils {
    private static ClassPathXmlApplicationContext applicationContext;

    public static ClassPathXmlApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void init() {
       applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    }
}
