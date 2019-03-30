package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.service.IWxbGoodService;
import com.qianfeng.fxmall.goods.service.impl.WxbGoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WxbGoodServlet extends BaseServlet {
    private IWxbGoodService goodService = new WxbGoodServiceImpl();

    /**
     * 分页
     */
    public void wxbGoodList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("pageNo");
        page=(page==null)?"1":page;
        int pageNo = Integer.parseInt(page);
        List<WxbGood> wxbGoods = goodService.selectWxbGoodByPage(pageNo);
        String goodName = wxbGoods.get(0).getGoodName();
        req.setAttribute("wxbGoods",wxbGoods);
        req.getRequestDispatcher("GoodList.jsp").forward(req,resp);
    }
    /**
     * 添加
     */
    public void wxbGoodAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = goodService.wxbGoodCount();
        int pageLast = count%SystemConstantsUtils.Page.PAGE_SIZE==0?(count/SystemConstantsUtils.Page.PAGE_SIZE):count/SystemConstantsUtils.Page.PAGE_SIZE+1;
        req.getRequestDispatcher("WxbGood.do?m=wxbGoodList&pageNo="+pageLast).forward(req,resp);
    }
}
