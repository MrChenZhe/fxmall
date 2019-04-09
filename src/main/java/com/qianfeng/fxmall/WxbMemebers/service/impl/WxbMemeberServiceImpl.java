package com.qianfeng.fxmall.WxbMemebers.service.impl;

import com.qianfeng.fxmall.WxbMemebers.bean.WxbMemeber;
import com.qianfeng.fxmall.WxbMemebers.mapper.WxbMemeberMapper;
import com.qianfeng.fxmall.WxbMemebers.service.IWxbMemeberService;
import com.qianfeng.fxmall.commons.MD5Utils;
import com.qianfeng.fxmall.commons.info.RandString;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class WxbMemeberServiceImpl implements IWxbMemeberService {
    @Autowired
    private WxbMemeberMapper wxbMemeberMapper;
    @Override
    public void insertWxbMemeber(WxbMemeber WxbMemeber) {
        String memeberId = "";
        do{
            memeberId= RandString.generateString(10);
            WxbMemeber wxbMemeber = wxbMemeberMapper.selectWxbMemeberById(memeberId);
        }while (memeberId.equals(WxbMemeber.getMemeberId()));
        WxbMemeber.setMemeberId(memeberId);
        System.out.println("插入的ID为--------->"+memeberId);
        String MD5Password = MD5Utils.md5(WxbMemeber.getPassword(),WxbMemeber.getName());
        System.out.println("插入的密码为--------->"+MD5Password);
        WxbMemeber.setPassword(MD5Password);
        wxbMemeberMapper.insertWxbMemeber(WxbMemeber);
    }

    @Override
    public void updateWxbMemeber(WxbMemeber WxbMemeber) {
        String password = wxbMemeberMapper.selectWxbMemeberById(WxbMemeber.getMemeberId()).getPassword();
        if(!password.equals(WxbMemeber.getPassword())){
            String newPassword = MD5Utils.md5(WxbMemeber.getPassword(),WxbMemeber.getName());
            WxbMemeber.setPassword(newPassword);
        }
        wxbMemeberMapper.updateWxbMemeber(WxbMemeber);
    }

    @Override
    public List<WxbMemeber> selectWxbMemeber(int pageNo) {
        List<WxbMemeber> wxbMemebers = wxbMemeberMapper.selectWxbMemeber(pageNo, SystemConstantsUtils.Page.PAGE_SIZE);
        return wxbMemebers;
    }

    @Override
    public WxbMemeber selectWxbMemeberById(String memeberId) {
        WxbMemeber wxbMemeber = wxbMemeberMapper.selectWxbMemeberById(memeberId);
        return wxbMemeber;
    }

    @Override
    public int selectCount() {
        return wxbMemeberMapper.selectCount();
    }

    @Override
    public WxbMemeber loginCheck(WxbMemeber wxbMemeber) {
        System.out.println(wxbMemeber.getName()+"---------------"+wxbMemeber.getPassword());
        List<WxbMemeber> wxbMemebers = wxbMemeberMapper.selectWxbMemeberName(wxbMemeber.getName());
        String newPassword = MD5Utils.md5(wxbMemeber.getPassword(),wxbMemeber.getName());
        WxbMemeber b = null;
        for(WxbMemeber w:wxbMemebers){
            if(w.getPassword().equals(newPassword)){
                b=w;
                break;
            }
        }
        return b;
    }

    @Override
    public void deleteWxbMemeber(String memeberId) {
        wxbMemeberMapper.deleteWxbMemeber(memeberId);
    }
}
