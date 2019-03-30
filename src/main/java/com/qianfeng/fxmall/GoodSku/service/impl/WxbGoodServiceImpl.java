/*
package com.qianfeng.fxmall.GoodSku.service.impl;

import com.qianfeng.fxmall.GoodSku.bean.WxbGood;
import com.qianfeng.fxmall.GoodSku.dao.IWxbGoodSkuDAO;
import com.qianfeng.fxmall.GoodSku.dao.impl.WxbGoodDAOImpl;
import com.qianfeng.fxmall.GoodSku.service.IWxbGoodService;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;

import java.util.List;

public class WxbGoodServiceImpl implements IWxbGoodService {
    IWxbGoodSkuDAO goodDAO = new WxbGoodDAOImpl();
    @Override
    public List<WxbGood> selectWxbGoodByPage(int Page) {
        Page = (Page-1)* SystemConstantsUtils.Page.PAGE_SIZE;
        List<WxbGood> wxbGoods = goodDAO.selectWxbGoodByPage(Page);
        return wxbGoods;
    }

    @Override
    public void insertWxbGoodAndSku(WxbGood wxbGood) {
        goodDAO.insertWxbGoodAndSku(wxbGood);
    }

    @Override
    public void updateWxbGood(WxbGood wxbGood) {
        goodDAO.updateWxbGood(wxbGood);
    }

    @Override
    public void deleteGood(Integer goodId) {
        goodDAO.deleteGood(goodId);
    }

    @Override
    public int wxbGoodCount() {
        return goodDAO.wxbGoodCount();
    }
}
*/
