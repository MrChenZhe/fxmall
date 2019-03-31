package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.WxbGoodTypes.bean.WxbGoodType;
import com.qianfeng.fxmall.commons.info.RandString;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.service.IWxbGoodService;
import com.qianfeng.fxmall.goods.service.impl.WxbGoodServiceImpl;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

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
    public void wxbGoodAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, FileUploadException {
        String op = req.getParameter("op");
        if("selectgoodType".equals(op)){
            List<WxbGoodType> wxbGoodTypes = goodService.selectAllGoodType();
            req.setAttribute("wxbGoodTypes",wxbGoodTypes);
            req.getRequestDispatcher("GoodAdd.jsp").forward(req,resp);
        }else if("add".equals(op)){
            int count = goodService.wxbGoodCount();
            int pageLast = count % SystemConstantsUtils.Page.PAGE_SIZE == 0 ? (count / SystemConstantsUtils.Page.PAGE_SIZE) : count / SystemConstantsUtils.Page.PAGE_SIZE + 1;
            String goodId="14886110";
            do {
                goodId = RandString.generateString(10);
            }while (goodService.selectGoodName(goodId));
//            文件域读取
            if(ServletFileUpload.isMultipartContent(req)){
                ServletFileUpload upload = new ServletFileUpload();
                FileItemIterator item = upload.getItemIterator(req);
                while (item.hasNext()){
                    FileItemStream stream = item.next();
                    String value = Streams.asString(stream.openStream(), "UTF-8");
                    WxbGood wxbGood = new WxbGood();
                    WxbGoodSku wxbGoodSku = new WxbGoodSku();
                    if(stream.isFormField()){
                        switch (stream.getFieldName()){
                            case "sku_str":

                        }
                    }else{
                        switch (stream.getFieldName()){

                        }
                    }
                }
            }
            req.getRequestDispatcher("WxbGood.do?m=wxbGoodList&pageNo=" + pageLast).forward(req, resp);
        }
    }
}
