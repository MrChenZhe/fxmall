import com.qianfeng.fxmall.WxbGoodTypes.bean.WxbGoodType;
import com.qianfeng.fxmall.WxbGoodTypes.service.IWxbGoodTypeService;
import com.qianfeng.fxmall.WxbGoodTypes.service.impl.WxbGoodTypeServiceImpl;
import com.qianfeng.fxmall.goods.service.IWxbGoodService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class GoodTypeTest {
    @Qualifier("WxbGoodTypeServiceImpl")
    @Autowired
    IWxbGoodTypeService gts ;
    @Test
    public void testAdd(){
        WxbGoodType wxbGoodType = new WxbGoodType("09","日用品","121332","生活用品",1,"666666");
        gts.insertGoodType(wxbGoodType);
    }
    @Test
    public void testupdate() {
        WxbGoodType wxbGoodType = new WxbGoodType("09", "日常用品", "123333", "生活小用品", 3, "333333");
        gts.updateGoodType(wxbGoodType);
    }
    @Test
    public void testdelete() {
        gts.deleteGoodType("08");
    }
    @Test
    public void selectById() {
        WxbGoodType wxbGoodType = gts.selectGoodTypeById("09");
        System.out.println(1);
    }
    @Test
    public void selectByPage() {
        List<WxbGoodType> wxbGoodTypes = gts.selectGoodTypeByPage(1);
        System.out.println(1);
    }
    @Test
    public void selectAll() {
        List<WxbGoodType> wxbGoodTypes = gts.selectAllGoodType();
        System.out.println(1);
    }
}
