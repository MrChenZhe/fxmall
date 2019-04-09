package com.qianfeng.fxmall.WxbMemebers.controller;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.GoodSku.service.IWxbGoodSkuService;
import com.qianfeng.fxmall.WxbGoodTypes.bean.WxbGoodType;
import com.qianfeng.fxmall.WxbGoodTypes.service.IWxbGoodTypeService;
import com.qianfeng.fxmall.WxbMemebers.bean.WxbMemeber;
import com.qianfeng.fxmall.WxbMemebers.service.IWxbMemeberService;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.commons.mybatis.SpringApplicationContextUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.service.IWxbGoodService;
import com.qianfeng.fxmall.goods.service.impl.WxbGoodServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class WxbMemeberServlet extends BaseServlet {
    IWxbMemeberService wxbMemeberServiceImpl = (IWxbMemeberService) SpringApplicationContextUtils.getApplicationContext().getBean("wxbMemeberServiceImpl");

    /**
     *登录验证
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        WxbMemeber wxbMemeber  = (WxbMemeber) SpringApplicationContextUtils.getApplicationContext().getBean("wxbMemeber");
        wxbMemeber.setName(username);
        wxbMemeber.setPassword(password);
        WxbMemeber validation = wxbMemeberServiceImpl.loginCheck(wxbMemeber);
        req.getSession().setAttribute("wxbMemeber",validation);
        if(validation!=null){
            req.getRequestDispatcher("WxbGood.do?m=wxbGoodList").forward(req,resp);
        }else{
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}