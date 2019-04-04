package com.qianfeng.fxmall.commons.Listener;

import com.qianfeng.fxmall.commons.mybatis.SpringApplicationContextUtils;
import com.qianfeng.fxmall.goods.service.IWxbGoodService;
import com.qianfeng.fxmall.goods.service.impl.WxbGoodServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        SpringApplicationContextUtils.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
