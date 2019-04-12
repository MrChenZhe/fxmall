package com.qianfeng.fxmall.WxbMemebers.service;

import com.qianfeng.fxmall.WxbMemebers.Exception.AccountNotFoundException;
import com.qianfeng.fxmall.WxbMemebers.Exception.PasswordWrongException;
import com.qianfeng.fxmall.WxbMemebers.VO.LoginVO;
import com.qianfeng.fxmall.WxbMemebers.bean.WxbMemeber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IWxbMemeberService {
    void insertWxbMemeber(WxbMemeber WxbMemeber);
    void updateWxbMemeber(WxbMemeber WxbMemeber);
    List<WxbMemeber> selectWxbMemeber(int pageNo);
    WxbMemeber selectWxbMemeberById(String memeberId);
    int selectCount();
    WxbMemeber loginCheck(LoginVO LoginVO) throws PasswordWrongException, AccountNotFoundException;
    void deleteWxbMemeber(String memeberId);
}
