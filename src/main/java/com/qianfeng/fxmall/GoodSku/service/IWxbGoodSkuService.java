package com.qianfeng.fxmall.GoodSku.service;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.goods.bean.WxbGood;

import java.util.List;

public interface IWxbGoodSkuService {
    List<WxbGoodSku> selectWxbGoodByPage(int Page);
    void  insertWxbGoodAndSku(WxbGoodSku wxbGood);
    void  updateWxbGood(WxbGoodSku wxbGood);
    void deleteGood(String goodId);
    int wxbGoodCount();
    Boolean selectGoodSkuId(String goodId);
    String createId();
}
