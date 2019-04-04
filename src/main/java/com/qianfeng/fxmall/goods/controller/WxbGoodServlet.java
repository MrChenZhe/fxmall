package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.WxbGoodTypes.bean.WxbGoodType;
import com.qianfeng.fxmall.commons.info.RandString;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.commons.mybatis.SpringApplicationContextUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.service.IWxbGoodService;
import com.qianfeng.fxmall.goods.service.impl.WxbGoodServiceImpl;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class WxbGoodServlet extends BaseServlet {
    IWxbGoodService goodService =  SpringApplicationContextUtils.getApplicationContext().getBean(WxbGoodServiceImpl.class);

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
        int i=0;
        if("selectgoodType".equals(op)){
            List<WxbGoodType> wxbGoodTypes = goodService.selectAllGoodType();
            req.setAttribute("wxbGoodTypes",wxbGoodTypes);
            req.getRequestDispatcher("GoodAdd.jsp").forward(req,resp);
        }else if("add".equals(op)){
            WxbGood wxbGood = new WxbGood();
            WxbGoodSku wxbGoodSku = new WxbGoodSku();
            int count = goodService.wxbGoodCount();
            int pageLast = count % SystemConstantsUtils.Page.PAGE_SIZE == 0 ? (count / SystemConstantsUtils.Page.PAGE_SIZE) : count / SystemConstantsUtils.Page.PAGE_SIZE + 1;
//            文件域读取
            if(ServletFileUpload.isMultipartContent(req)){
                ServletFileUpload upload = new ServletFileUpload();
                FileItemIterator item = upload.getItemIterator(req);
                while (item.hasNext()){
                    FileItemStream stream = item.next();
                    String value = Streams.asString(stream.openStream(), "UTF-8");
                    if(stream.isFormField()){
                        switch (stream.getFieldName()){
                            case "good_name":
                                wxbGood.setGoodName(value);
                                break;
                            case "type_id":
                                wxbGood.setTypeId(value);
                                break;
                            case "order_no":
                                wxbGood.setOrderNo(parse(value));
                                wxbGoodSku.setOrderNo(parse(value));
                                break;
                            case "sell_num":
                                wxbGood.setSellNum(parse(value));
                                break;
                            case "promote_desc":
                                wxbGood.setPromoteDesc(value);
                                break;
                            case "tags":
                                wxbGood.setTags(value);
                                break;
                            case "copy_desc":
                                wxbGood.setCopyDesc(value);
                                break;
                            case "forward_link":
                                wxbGood.setForwardLink(value);
                                break;
                            case "copy_id":
                                wxbGood.setCopyIds(value);
                                break;
                            case "spc_id":
                                wxbGood.setSpcId(value);
                                break;
                            case "zon_id":
                                wxbGood.setZonId(value);
                                break;
//                            WxbGoodSku的属性
                            case "sku_name":
                                wxbGoodSku.setSkuName(value);
                                break;
                            case "sku_cost":
                                wxbGoodSku.setSkuCost(value);
                                break;
                            case "sku_price":
                                wxbGoodSku.setSkuPrice (value);
                                break;
                            case "sku_pmoney":
                                wxbGoodSku.setSkuPmoney(value);
                                break;
                            case "service_money":
                                wxbGoodSku.setServiceMoney(value);
                                break;
                        }
                    }else{
                        String filePath = stream.getName();
                        if(filePath!=null){
                            String fileDB = UUID.randomUUID().toString()+filePath.substring(filePath.lastIndexOf("."));
                            filePath=SystemConstantsUtils.UPLOADPATH+fileDB;
                            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
                            Streams.copy(stream.openStream(),outputStream,true);
                            if(i<3){
                                if(i==0){
                                    wxbGood.setGoodPic(fileDB);
                                    i++;
                                }else if(i==1){
                                    wxbGood.setGoodPic1(fileDB);
                                    i++;
                                }else if(i==2){
                                    wxbGood.setGoodPic2(fileDB);
                                    i++;
                                }
                            }
                        }
                    }

                }
            }
            wxbGood.setGoodId(goodService.createId());
            wxbGoodSku.setSkuId(new WxbGoodServiceImpl().createId());
            wxbGood.setCreateTime(new Timestamp(System.currentTimeMillis()));
            req.getRequestDispatcher("WxbGood.do?m=wxbGoodList&pageNo=" + pageLast).forward(req, resp);
        }
    }
    public int parse(String value){
        int i = Integer.parseInt(value);
        return i;
    }
}
