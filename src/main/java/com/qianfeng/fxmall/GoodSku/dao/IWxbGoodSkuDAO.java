package com.qianfeng.fxmall.GoodSku.dao;


import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;

import java.util.List;

public interface IWxbGoodSkuDAO {
    List<WxbGoodSku> selectWxbGoodByPage(int Page);
    void  insertWxbGoodAndSku(WxbGoodSku WxbGoodSku);
    void  updateWxbGood(WxbGoodSku WxbGoodSku);
    void deleteGood(Integer goodId);
    int wxbGoodCount();
}
