package com.qianfeng.fxmall.GoodSku.dao.impl;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.GoodSku.dao.IWxbGoodSkuDAO;
import com.qianfeng.fxmall.GoodSku.mapper.WxbGoodSkuMapper2;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("WxbGoodSkuDAOImpl")
public class WxbGoodSkuDAOImpl implements IWxbGoodSkuDAO {
@Autowired
 private WxbGoodSkuMapper2 wxbGoodSkuMapper2;
    @Override
    public List<WxbGoodSku> selectWxbGoodByPage(int Page) {
     List<WxbGoodSku> wxbGoodSkus = wxbGoodSkuMapper2.wxbGoodSkuSelect(Page, SystemConstantsUtils.Page.PAGE_SIZE);
     return wxbGoodSkus;
    }

    @Override
    public void insertWxbGoodAndSku(WxbGoodSku WxbGoodSku) {
        wxbGoodSkuMapper2.insertWxbGoodSku(WxbGoodSku);
    }

    @Override
    public void updateWxbGood(WxbGoodSku WxbGoodSku) {
        wxbGoodSkuMapper2.updateWxbGoodSku(WxbGoodSku);
    }

    @Override
    public void deleteGood(Integer goodId) {
        wxbGoodSkuMapper2.wxbGoodSkuDelete(goodId);
    }

    @Override
    public int wxbGoodCount() {
     return  wxbGoodSkuMapper2.selectCount();
    }
    @Override
    public String selectID(String sku_id) {
     return wxbGoodSkuMapper2.selectID(sku_id);
    }
}
