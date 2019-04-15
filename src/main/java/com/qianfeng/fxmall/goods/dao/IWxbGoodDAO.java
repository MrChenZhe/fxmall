package com.qianfeng.fxmall.goods.dao;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.vo.GoodAddVO;

import java.util.List;

public interface IWxbGoodDAO {
    List<WxbGood> selectWxbGoodByPage(int Page);
    void  insertWxbGoodAndSku(WxbGood wxbGood);
    void  updateWxbGood(WxbGood wxbGood);
    void deleteGood(Integer goodId);
    int wxbGoodCount();
    String selectGoodName(String goodName);
    WxbGood selectGoodById(String goodId);
    void insertGoodAddVo(GoodAddVO goodAddVO);
}
