package GoodText;

import com.qianfeng.fxmall.commons.info.RandString;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IWxbGoodDAO;
import com.qianfeng.fxmall.goods.dao.impl.WxbGoodDAOImpl;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

public class Good {
    IWxbGoodDAO dao = new WxbGoodDAOImpl();
    @Test
    public void count(){
        //123321
        int i = dao.wxbGoodCount();
        System.out.println(i);
    }
    @Test
    public void add(){
        //123
        Timestamp date = new Timestamp(System.currentTimeMillis());
        String goodId = RandString.generateMixString(10);
        WxbGood wxbGood = new WxbGood(goodId, "366", "69609206", "imageFolder/20160509/44671132_1.jpg", "imageFolder/20160509/44671132_2.jpg", "imageFolder/20160509/44671132_3.jpg", "11", "1", "1", "1", "1", "1", null, null, 3, "01", "2", 1, date, 0, 0, null, null, "9", null, 11, null, 0, 1, 7, "0");
        dao.insertWxbGoodAndSku(wxbGood);
    }
}
