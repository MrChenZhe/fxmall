package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.goods.service.IWxbGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String m = req.getParameter("m");
        try {
            Logger.getLogger("开始执行了方法"+m);
            Method method = this.getClass().getMethod(m, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
            Logger.getLogger("执行完了方法"+m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    @Autowired
    public IWxbGoodService goodService;
    @Override
    public void init(ServletConfig config){
        try {
            super.init(config);
            SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,config.getServletContext());
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
