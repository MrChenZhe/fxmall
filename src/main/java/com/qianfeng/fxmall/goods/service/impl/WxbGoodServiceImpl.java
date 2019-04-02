package com.qianfeng.fxmall.goods.service.impl;

import com.qianfeng.fxmall.WxbGoodTypes.bean.WxbGoodType;
import com.qianfeng.fxmall.WxbGoodTypes.service.impl.WxbGoodTypeServiceImpl;
import com.qianfeng.fxmall.commons.info.RandString;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IWxbGoodDAO;
import com.qianfeng.fxmall.goods.dao.impl.WxbGoodDAOImpl;
import com.qianfeng.fxmall.goods.service.IWxbGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("WxbGoodServiceImpl")
public class WxbGoodServiceImpl implements IWxbGoodService {
    @Qualifier("WxbGoodDAOImpl")
    @Autowired
    private IWxbGoodDAO goodDAO;
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
    @Override
    public List<WxbGoodType> selectAllGoodType() {
       List<WxbGoodType> wxbGoodTypes = new WxbGoodTypeServiceImpl().selectAllGoodType();
        return wxbGoodTypes;
    }

    @Override
    public Boolean selectGoodName(String goodId) {
        String goodName = goodDAO.selectGoodName(goodId);
        if(goodName!=null){
            return false;
        }
        return true;
    }

    @Override
    public String createId() {
        String id = "14886110";
        do {
            id = RandString.generateString(10);
        }while(selectGoodName(id));
        return id;
    }
}
