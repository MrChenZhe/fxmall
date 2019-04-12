package com.qianfeng.fxmall.WxbMemebers.service.impl;

import com.qianfeng.fxmall.WxbMemebers.Exception.AccountNotFoundException;
import com.qianfeng.fxmall.WxbMemebers.Exception.PasswordWrongException;
import com.qianfeng.fxmall.WxbMemebers.VO.LoginVO;
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
        String MD5Password = MD5Utils.md5(WxbMemeber.getPassword(),WxbMemeber.getAccount());
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
    public WxbMemeber loginCheck(LoginVO loginVO) throws PasswordWrongException, AccountNotFoundException {
        System.out.println(loginVO.getUsername()+"---------------"+loginVO.getPassword());
        WxbMemeber wxbMemeber = wxbMemeberMapper.selectWxbMemeberAccount(loginVO.getUsername());
        if(wxbMemeber==null){
            throw  new AccountNotFoundException("账号错误");

        }
        String newPassword = MD5Utils.md5(loginVO.getPassword(),wxbMemeber.getAccount());
        System.out.println("待验证密码加密后结果为"+newPassword);
        if(!newPassword.equals(wxbMemeber.getPassword())){
           throw  new PasswordWrongException("密码错误------》"+loginVO.getPassword());

        }
        return wxbMemeber;
    }

    @Override
    public void deleteWxbMemeber(String memeberId) {
        wxbMemeberMapper.deleteWxbMemeber(memeberId);
    }
}
