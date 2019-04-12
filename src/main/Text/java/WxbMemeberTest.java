import com.qianfeng.fxmall.WxbMemebers.Exception.AccountNotFoundException;
import com.qianfeng.fxmall.WxbMemebers.Exception.PasswordWrongException;
import com.qianfeng.fxmall.WxbMemebers.VO.LoginVO;
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
        wxbMemeber.setMemeberId("666");
        wxbMemeber.setAccount("666");
        wxbMemeber.setQqNum("666");
        wxbMemeber.setPhone("666");
        wxbMemeber.setPayAccount("666");
        wxbMemeber.setName("陈哲666");
        wxbMemeber.setPassword("123456");
        wxbMemeber.setUseRecom(1L);
        wxbMemeber.setLevelCode("666");
        wxbMemeber.setMid(666L);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        wxbMemeber.setUpdateTime(timestamp);
        wxbMemeber.setRegisterTime(timestamp);
        wxbMemeberServiceImpl.insertWxbMemeber(wxbMemeber);
    }
    @Test
    public void loginValidate(){
        LoginVO wxbMemeber = new LoginVO();
        wxbMemeber.setUsername("666");
        wxbMemeber.setPassword("123456");
        WxbMemeber memeber = null;
        try {
            memeber = wxbMemeberServiceImpl.loginCheck(wxbMemeber);
        } catch (PasswordWrongException e) {
            e.printStackTrace();
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(memeber.getMemeberId());
    }
}
