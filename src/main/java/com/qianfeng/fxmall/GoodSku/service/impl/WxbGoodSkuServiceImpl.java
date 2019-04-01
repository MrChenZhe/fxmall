
package com.qianfeng.fxmall.GoodSku.service.impl;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.GoodSku.dao.IWxbGoodSkuDAO;
import com.qianfeng.fxmall.GoodSku.dao.impl.WxbGoodSkuDAOImpl;
import com.qianfeng.fxmall.GoodSku.service.IWxbGoodSkuService;
import com.qianfeng.fxmall.commons.info.RandString;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;

import java.util.List;

public class WxbGoodSkuServiceImpl implements IWxbGoodSkuService {
    IWxbGoodSkuDAO goodDAO = new WxbGoodSkuDAOImpl();


    @Override
    public List<WxbGood> selectWxbGoodByPage(int Page) {
        return null;
    }

    @Override
    public void insertWxbGoodAndSku(WxbGood wxbGood) {

    }

    @Override
    public void updateWxbGood(WxbGood wxbGood) {

    }

    @Override
    public void deleteGood(Integer goodId) {

    }

    @Override
    public int wxbGoodCount() {
        return 0;
    }

    @Override
    public Boolean selectGoodSkuId(String goodId) {
        return null;
    }

    @Override
    public String createId() {
        return null;
    }
}

