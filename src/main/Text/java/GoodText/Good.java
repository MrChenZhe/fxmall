package GoodText;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.GoodSku.service.IWxbGoodSkuService;
import com.qianfeng.fxmall.commons.info.RandString;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.impl.WxbGoodDAOImpl;
import com.qianfeng.fxmall.goods.service.IWxbGoodService;
import com.qianfeng.fxmall.goods.service.impl.WxbGoodServiceImpl;
import com.qianfeng.fxmall.goods.vo.GoodAddVO;
import com.sun.org.apache.xml.internal.utils.StringToStringTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class Good {
    @Qualifier("WxbGoodServiceImpl")
    @Autowired
    private IWxbGoodService dao;
    @Qualifier("WxbGoodSkuServiceImpl")
    @Autowired
    private IWxbGoodSkuService skuService;
    @Test
    public void count(){
        int i = dao.wxbGoodCount();
        System.out.println(i);
    }
    @Test
    public void add(){
        //123
        Timestamp date = new Timestamp(System.currentTimeMillis());
        String goodId = RandString.generateMixString(10);
        WxbGood wxbGood = new WxbGood(goodId, "391", "69609206", "imageFolder/20160509/44671132_1.jpg", "imageFolder/20160509/44671132_2.jpg", "imageFolder/20160509/44671132_3.jpg", "11", "1", "1", "1", "1", "1", null, null, 3, "01", "2", 1, date, 0, 0, null, null, "9", null, 11, null, 0, 1, 7, "0");
        dao.insertWxbGoodAndSku(wxbGood);
    }
    @Test
    public void select(){
        WxbGood wxbGood = dao.selectGoodById("pb1n3rya");
        System.out.println("wxbGood = " + wxbGood);
    }
    @Test
    public void test1(){
        String file ="161.jpg";
        String substring = file.substring(file.lastIndexOf("."));
        System.out.println(substring);
    }
    @Test
    public void str(){
        GoodAddVO goodAddVO= new GoodAddVO();
        String st="newid|1|2|3|4|5|$newid|6|7|8|9|10|$";

        String info=st.replace("$","");
        String[] skus = info.split("newid\\|");
       // goodAddVO.setGood_id(dao.createId());
        for(String sku :skus) {
            if(!"".equals(sku)){
                WxbGoodSku wxbGoodSku = new WxbGoodSku();
                String[] goodSku = sku.split("\\|");
                for (int j = 0; j < goodSku.length - 1; j++) {
                    wxbGoodSku.setSkuName(goodSku[0]);
                    wxbGoodSku.setSkuCost(goodSku[1]);
                    wxbGoodSku.setSkuPrice(goodSku[2]);
                    wxbGoodSku.setSkuPmoney(goodSku[3]);
                    wxbGoodSku.setServiceMoney(goodSku[4]);
                    wxbGoodSku.setOrderNo(goodAddVO.getOrder_no());
                    wxbGoodSku.setServiceMoney(goodAddVO.getService_money());
                }
            }
        }
    }
    @Test
    public void test333(){
        List<WxbGoodSku> wxbGoodSkus = skuService.selectWxbGoodByPage(1);
        String id = skuService.createId();
        System.out.println(id);
    }
    @Test
    public void test3(){
        String id = dao.createId();
        System.out.println(id);
    }
}
