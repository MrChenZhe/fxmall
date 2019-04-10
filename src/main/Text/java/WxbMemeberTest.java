import com.qianfeng.fxmall.WxbMemebers.bean.WxbMemeber;
import com.qianfeng.fxmall.WxbMemebers.service.IWxbMemeberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class WxbMemeberTest {
    @Autowired
    private IWxbMemeberService wxbMemeberServiceImpl;
    @Test
    public void add(){
        WxbMemeber wxbMemeber = new WxbMemeber();
        wxbMemeber.setMemeberId("122");
        wxbMemeber.setAccount("123");
        wxbMemeber.setQqNum("122");
        wxbMemeber.setPhone("122");
        wxbMemeber.setPayAccount("122");
        wxbMemeber.setName("陈哲");
        wxbMemeber.setPassword("123456");
        wxbMemeber.setUseRecom(1L);
        wxbMemeber.setLevelCode("122");
        wxbMemeber.setMid(1222L);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        wxbMemeber.setUpdateTime(timestamp);
        wxbMemeber.setRegisterTime(timestamp);
        wxbMemeberServiceImpl.insertWxbMemeber(wxbMemeber);
    }
    @Test
    public void loginValidate(){
        WxbMemeber wxbMemeber = new WxbMemeber();
        wxbMemeber.setName("陈哲");
        wxbMemeber.setPassword("123456");
        WxbMemeber memeber = wxbMemeberServiceImpl.loginCheck(wxbMemeber);
        System.out.println(memeber.getEmail());
    }
}
