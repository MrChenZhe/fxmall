package com.qianfeng.fxmall.GoodSku.service;

import com.qianfeng.fxmall.goods.bean.WxbGood;

import java.util.List;

public interface IWxbGoodSkuService {
    List<WxbGood> selectWxbGoodByPage(int Page);
    void  insertWxbGoodAndSku(WxbGood wxbGood);
    void  updateWxbGood(WxbGood wxbGood);
    void deleteGood(Integer goodId);
    int wxbGoodCount();
    Boolean selectGoodSkuId(String goodId);
    String createId();
}
