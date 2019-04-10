package com.qianfeng.fxmall.WxbMemebers.controller;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.GoodSku.service.IWxbGoodSkuService;
import com.qianfeng.fxmall.WxbGoodTypes.bean.WxbGoodType;
import com.qianfeng.fxmall.WxbGoodTypes.service.IWxbGoodTypeService;
import com.qianfeng.fxmall.WxbMemebers.VO.JsonVO;
import com.qianfeng.fxmall.WxbMemebers.VO.LoginVO;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
@Controller
public class WxbMemeberServlet  {
    @Autowired
    IWxbMemeberService wxbMemeberServiceImpl;

    /**
     *登录验证
     */
    @PostMapping("/memeberlogin")
    @ResponseBody
    public JsonVO login(LoginVO loginVO){
        System.out.println(loginVO);
        WxbMemeber validation = wxbMemeberServiceImpl.loginCheck(wxbMemeber);
        req.getSession().setAttribute("wxbMemeber",validation);
        if(validation!=null){
            String json = "true#登录成功";
            resp.getWriter().write(json);
        }else{
            String json = "true#登录成功";
            resp.getWriter().write(json);
        }
    }
}