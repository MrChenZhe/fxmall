package com.qianfeng.fxmall.GoodSku.dao.impl;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.GoodSku.dao.IWxbGoodSkuDAO;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryUtils;
import com.qianfeng.fxmall.goods.mapper.WxbGoodMapper;

import java.util.List;

public class WxbGoodSkuDAOImpl implements IWxbGoodSkuDAO {
    @Override
    public List<WxbGoodSku> selectWxbGoodByPage(int Page) {

        return null;
    }

    @Override
    public void insertWxbGoodAndSku(WxbGoodSku WxbGoodSku) {

    }

    @Override
    public void updateWxbGood(WxbGoodSku WxbGoodSku) {

    }

    @Override
    public void deleteGood(Integer goodId) {

    }

    @Override
    public int wxbGoodCount() {
        return 0;
    }
}
