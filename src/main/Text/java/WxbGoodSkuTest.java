import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.GoodSku.dao.IWxbGoodSkuDAO;
import com.qianfeng.fxmall.GoodSku.dao.impl.WxbGoodSkuDAOImpl;
import org.junit.Test;

import java.util.List;

public class WxbGoodSkuTest {
    IWxbGoodSkuDAO gd =  new WxbGoodSkuDAOImpl();
    @Test
    public void testAdd(){
        WxbGoodSku wxbGoodSku = new WxbGoodSku ("0000000001", "1", "2", "3", "4", "8Enh5BM9nB",3, "5");
        gd.insertWxbGoodAndSku(wxbGoodSku);
    }
    @Test
    public void testupdate(){
        WxbGoodSku wxbGoodSku = new WxbGoodSku ("0000000001", "2", "2", "3", "4", "8Enh5BM9nB",3, "5");
        gd.updateWxbGood(wxbGoodSku);
    }
    @Test
    public void testselect(){
        List<WxbGoodSku> wxbGoodSkus = gd.selectWxbGoodByPage(1);
       wxbGoodSkus.forEach((c)-> System.out.println(c.getSkuName()));
    }
    @Test
    public void testdelete(){
        gd.deleteGood(0000000001);
    }
}
