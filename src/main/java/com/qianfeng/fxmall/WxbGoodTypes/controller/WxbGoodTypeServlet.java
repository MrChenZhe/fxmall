package com.qianfeng.fxmall.WxbGoodTypes.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WxbGoodTypeServlet extends BaseServlet {

    /**
     * 分页
     */
    public void wxbGoodList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("pageNo");
        page=(page==null)?"1":page;
        int pageNo = Integer.parseInt(page);

    }
    /**
     * 添加
     */
    public void wxbGoodAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int count = goodService.wxbGoodCount();
//        int pageLast = count%SystemConstantsUtils.Page.PAGE_SIZE==0?(count/SystemConstantsUtils.Page.PAGE_SIZE):count/SystemConstantsUtils.Page.PAGE_SIZE+1;
//        req.getRequestDispatcher("WxbGood.do?m=wxbGoodList&pageNo="+pageLast).forward(req,resp);
    }
}
