package GoodText;

import com.qianfeng.fxmall.commons.info.RandString;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.impl.WxbGoodDAOImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class Good {
    @Qualifier("WxbGoodDAOImpl")
    @Autowired
    private WxbGoodDAOImpl dao;
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
        WxbGood wxbGood = new WxbGood(goodId, "369", "69609206", "imageFolder/20160509/44671132_1.jpg", "imageFolder/20160509/44671132_2.jpg", "imageFolder/20160509/44671132_3.jpg", "11", "1", "1", "1", "1", "1", null, null, 3, "01", "2", 1, date, 0, 0, null, null, "9", null, 11, null, 0, 1, 7, "0");
        dao.insertWxbGoodAndSku(wxbGood);
    }
}
