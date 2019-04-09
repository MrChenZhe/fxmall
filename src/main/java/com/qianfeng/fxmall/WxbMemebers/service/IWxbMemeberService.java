package com.qianfeng.fxmall.WxbMemebers.service;

import com.qianfeng.fxmall.WxbMemebers.bean.WxbMemeber;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IWxbMemeberService {
    void insertWxbMemeber(WxbMemeber WxbMemeber);
    void updateWxbMemeber(WxbMemeber WxbMemeber);
    List<WxbMemeber> selectWxbMemeber(int pageNo);
    WxbMemeber selectWxbMemeberById(String memeberId);
    int selectCount();
    WxbMemeber loginCheck(WxbMemeber wxbMemeber);
    void deleteWxbMemeber(String memeberId);
}
