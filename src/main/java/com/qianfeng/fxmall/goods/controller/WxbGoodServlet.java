package com.qianfeng.fxmall.goods.controller;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.GoodSku.service.IWxbGoodSkuService;
import com.qianfeng.fxmall.GoodSku.service.impl.WxbGoodSkuServiceImpl;
import com.qianfeng.fxmall.WxbGoodTypes.bean.WxbGoodType;
import com.qianfeng.fxmall.WxbGoodTypes.service.IWxbGoodTypeService;
import com.qianfeng.fxmall.WxbGoodTypes.service.impl.WxbGoodTypeServiceImpl;
import com.qianfeng.fxmall.commons.MD5Utils;
import com.qianfeng.fxmall.commons.info.RandString;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.commons.mybatis.SpringApplicationContextUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.service.IWxbGoodService;
import com.qianfeng.fxmall.goods.service.impl.WxbGoodServiceImpl;
import com.qianfeng.fxmall.goods.vo.GoodAddVO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
@Controller
public class WxbGoodServlet {
    @Qualifier("WxbGoodServiceImpl")
    @Autowired
    IWxbGoodService goodService;
    @Qualifier("WxbGoodTypeServiceImpl")
    @Autowired
    IWxbGoodTypeService typeService;
    @Qualifier("WxbGoodSkuServiceImpl")
    @Autowired
    IWxbGoodSkuService skuService;
    /**
     * 分页
     */
    @RequestMapping("/wxbGoodList")
    public String wxbGoodList(HttpServletRequest request,Model model){
        String page=request.getParameter("pageNo");
        page = (page == null||page=="0") ? "1" : page;
        int pageNo = Integer.parseInt(page);
        List<WxbGood> wxbGoods = goodService.selectWxbGoodByPage(pageNo);
        String goodName = wxbGoods.get(0).getGoodName();
        int count = goodService.wxbGoodCount();
        int pageNum=(count%SystemConstantsUtils.Page.PAGE_SIZE==0?count/SystemConstantsUtils.Page.PAGE_SIZE:count/SystemConstantsUtils.Page.PAGE_SIZE+1);
        model.addAttribute("wxbGoods",wxbGoods);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("pageNo",pageNo);
        model.addAttribute("count",count);
        model.addAttribute("size",SystemConstantsUtils.Page.PAGE_SIZE);
        return "GoodList";
    }
    /**
     * 添加前查询所有type
     */
    @GetMapping("addGoodSelectType")
    public String addGoodSelectType(Model model){
        List<WxbGoodType> wxbGoodTypes = typeService.selectAllGoodType();
        model.addAttribute("wxbGoodTypes", wxbGoodTypes);
        return "/GoodAdd";
    }
    /**
     * 添加
     */
    public void wxbGoodAdd2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, FileUploadException {
        String op = req.getParameter("op");
        int i = 0;
            WxbGood wxbGood = new WxbGood();
            WxbGoodSku wxbGoodSku = new WxbGoodSku();
            int count = goodService.wxbGoodCount();
            int pageLast = count % SystemConstantsUtils.Page.PAGE_SIZE == 0 ? (count / SystemConstantsUtils.Page.PAGE_SIZE) : count / SystemConstantsUtils.Page.PAGE_SIZE + 1;

            if (ServletFileUpload.isMultipartContent(req)) {
                ServletFileUpload upload = new ServletFileUpload();
                FileItemIterator item = upload.getItemIterator(req);
                while (item.hasNext()) {
                    FileItemStream stream = item.next();
                    String value = Streams.asString(stream.openStream(), "UTF-8");
                    if (stream.isFormField()) {
                        switch (stream.getFieldName()) {
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
                                wxbGoodSku.setSkuPrice(value);
                                break;
                            case "sku_pmoney":
                                wxbGoodSku.setSkuPmoney(value);
                                break;
                            case "service_money":
                                wxbGoodSku.setServiceMoney(value);
                                break;
                        }
                    } else {
                        String filePath = stream.getName();
                        if (filePath != null) {
                            String fileDB = UUID.randomUUID().toString() + filePath.substring(filePath.lastIndexOf("."));
                            filePath = SystemConstantsUtils.UPLOADPATH + fileDB;
                            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
                            Streams.copy(stream.openStream(), outputStream, true);
                            if (i < 3) {
                                if (i == 0) {
                                    wxbGood.setGoodPic(fileDB);
                                    i++;
                                } else if (i == 1) {
                                    wxbGood.setGoodPic1(fileDB);
                                    i++;
                                } else if (i == 2) {
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


    public int parse(String value) {
        int i = Integer.parseInt(value);
        return i;
    }
    /**
     * MVC添加商品
     */
    @PostMapping("wxbGoodAdd")
    public ModelAndView wxbGoodAdd(@RequestParam MultipartFile[] uploadGood, GoodAddVO goodAddVO){
        System.out.println("进入添加Controller");
        int i=1;
        System.out.println("multipartFile = [" + uploadGood + "]");
        if(uploadGood!=null){
            for (MultipartFile myfile:uploadGood){
                if(myfile.isEmpty()){
                    System.out.println("文件未上传");
                }else{
                    System.out.println("文件长度: " + myfile.getSize());
                    System.out.println("文件类型: " + myfile.getContentType());
                    System.out.println("文件名称: " + myfile.getName());
                    System.out.println("文件原名: " + myfile.getOriginalFilename());
                    String suffix=myfile.getOriginalFilename().substring(myfile.getOriginalFilename().lastIndexOf("."));
                    System.out.println("文件后缀"+suffix);
                    System.out.println("========================================");
                    try {
                        byte[] bytes = myfile.getBytes();
                        String md5 = MD5Utils.md5(bytes);
                        //判断数据库图片的MD5是否与上传的一致
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        InputStream inputStream = myfile.getInputStream();
                        FTPClient ftp = new FTPClient();
                        ftp.connect("192.168.53.6", 21);
                        boolean login = ftp.login("anonymous", "1756229479@qq.com");
                        System.out.println("登录是否成功？？？？？？？？？？"+login);
                        int replyCode = ftp.getReplyCode();
                        if (!FTPReply.isPositiveCompletion(replyCode)) {
                            System.out.println("获取响应失败");
                        }
                        //设置接收文件类型为二进制文件
                        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
                        //服务器上创建images文件夹
                        //ftp.makeDirectory("fxmallimages");
                        //切换ftp默认文件夹
                        ftp.changeWorkingDirectory("images/fxmallimages");
                        String filename = UUID.randomUUID().toString()+suffix;
                        ftp.storeFile(filename, inputStream);
                        //退出登录
                        ftp.logout();
                        switch (i){
                            case 1:
                                goodAddVO.setGoodPic("http://localhost:81/images/fxmallimages/"+filename);
                                i++;
                                break;
                            case 2:
                                goodAddVO.setGoodPic1("http://localhost:81/images/fxmallimages/"+filename);
                                i++;
                                break;
                            case 3:
                                goodAddVO.setGoodPic2("http://localhost:81/images/fxmallimages/"+filename);
                                break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中
//                String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
//                //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的
//                FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, myfile.getOriginalFilename()));
                }
                System.out.println(goodAddVO);
            }
        }
        String sku_strs = goodAddVO.getSku_str();
        sku_strs=sku_strs.replace("$","");
        String[] skus = sku_strs.split("newid\\|");
        goodAddVO.setGood_id(goodService.createId());
        for(String sku :skus){
            String[] goodSku = sku.split("\\|");
            if(!"".equals(sku)){
                    WxbGoodSku wxbGoodSku = new WxbGoodSku();
                    wxbGoodSku.setSkuId(skuService.createId());
                    wxbGoodSku.setGoodId(goodAddVO.getGood_id());
                    wxbGoodSku.setSkuName(goodSku[0]);
                    wxbGoodSku.setSkuCost(goodSku[1]);
                    wxbGoodSku.setSkuPrice(goodSku[2]);
                    wxbGoodSku.setSkuPmoney(goodSku[3]);
                    wxbGoodSku.setServiceMoney(goodSku[4]);
                    wxbGoodSku.setOrderNo(goodAddVO.getOrder_no());
                    skuService.insertWxbGoodAndSku(wxbGoodSku);

            }
        }
        //Good添加
        goodAddVO.setCreateTime(new Timestamp( System.currentTimeMillis()));
        goodAddVO.setTopedTime(new Timestamp( System.currentTimeMillis()));
        goodAddVO.setRecomedTime(new Timestamp( System.currentTimeMillis()));
        goodService.insertGoodAddVo(goodAddVO);
        int count = goodService.wxbGoodCount();
        int pageNum=(count%SystemConstantsUtils.Page.PAGE_SIZE==0?count/SystemConstantsUtils.Page.PAGE_SIZE:count/SystemConstantsUtils.Page.PAGE_SIZE+1);

        return new ModelAndView("redirect:/wxbGoodList?pageNo="+pageNum);
    }


    /**
     * 点击商品名称查找商品
     */
    @GetMapping("wxbGoodSelectByName")
    public String wxbGoodSelectByName(String goodId,Model model) {
        WxbGood good = goodService.selectGoodById(goodId);
        model.addAttribute("good",good);
        WxbGoodType wxbGoodType = typeService.selectGoodTypeById(good.getTypeId());
        model.addAttribute("wxbGoodType",wxbGoodType);
        return "GoodAdd";
    }

}