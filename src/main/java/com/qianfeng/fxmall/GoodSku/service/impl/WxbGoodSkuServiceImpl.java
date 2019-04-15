
package com.qianfeng.fxmall.GoodSku.service.impl;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.GoodSku.dao.IWxbGoodSkuDAO;
import com.qianfeng.fxmall.GoodSku.dao.impl.WxbGoodSkuDAOImpl;
import com.qianfeng.fxmall.GoodSku.service.IWxbGoodSkuService;
import com.qianfeng.fxmall.commons.info.RandString;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("WxbGoodSkuServiceImpl")
public class WxbGoodSkuServiceImpl implements IWxbGoodSkuService {
    @Qualifier("WxbGoodSkuDAOImpl")
    @Autowired
    private IWxbGoodSkuDAO goodDAO;


    @Override
    public List<WxbGoodSku> selectWxbGoodByPage(int Page) {
        goodDAO.selectWxbGoodByPage(Page);
        return null;
    }

    @Override
    public void insertWxbGoodAndSku(WxbGoodSku wxbGood) {
        goodDAO.insertWxbGoodAndSku(wxbGood);
    }

    @Override
    public void updateWxbGood(WxbGoodSku wxbGood) {
        goodDAO.updateWxbGood(wxbGood);
    }

    @Override
    public void deleteGood(String goodId) {
        goodDAO.deleteGood(goodId);
    }

    @Override
    public int wxbGoodCount() {
        return goodDAO.wxbGoodCount();
    }

    @Override
    public Boolean selectGoodSkuId(String goodId) {
        String selectID = goodDAO.selectID(goodId);
        if(selectID!=null){
            return false;
        }
        return true;
    }

    @Override
    public String createId() {
        String id="";
        do {
            id = RandString.generateString(10);
        }while(!selectGoodSkuId(id));
        return id;
    }
}

