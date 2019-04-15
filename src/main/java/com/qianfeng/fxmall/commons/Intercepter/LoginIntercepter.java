package com.qianfeng.fxmall.commons.Intercepter;

import com.qianfeng.fxmall.WxbMemebers.bean.WxbMemeber;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        WxbMemeber wxbMemeber = (WxbMemeber) request.getSession().getAttribute("wxbMemeber");
        if(wxbMemeber==null){
            System.out.println("未登录请先登录");
            //response.sendRedirect("login.jsp");
            return true;
        }
        System.out.println("亲爱的"+wxbMemeber.getName()+"欢迎回来");
        return true;
    }
}
