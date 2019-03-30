package com.qianfeng.fxmall.GoodSku.dao.impl;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.GoodSku.dao.IWxbGoodSkuDAO;
import com.qianfeng.fxmall.GoodSku.mapper.WxbGoodSkuMapper;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryUtils;

import java.util.List;

public class WxbGoodSkuDAOImpl implements IWxbGoodSkuDAO {
   WxbGoodSkuMapper mapper = MyBatisSessionFactoryUtils.getSesson().getMapper(WxbGoodSkuMapper.class);

    @Override
    public List<WxbGoodSku> selectWxbGoodByPage(int Page) {
     List<WxbGoodSku> wxbGoodSkus = mapper.wxbGoodSkuSelect(Page, SystemConstantsUtils.Page.PAGE_SIZE);
     return wxbGoodSkus;
    }

    @Override
    public void insertWxbGoodAndSku(WxbGoodSku WxbGoodSku) {
        mapper.insertWxbGoodSku(WxbGoodSku);
    }

    @Override
    public void updateWxbGood(WxbGoodSku WxbGoodSku) {
        mapper.updateWxbGoodSku(WxbGoodSku);
    }

    @Override
    public void deleteGood(Integer goodId) {
         mapper.wxbGoodSkuDelete(goodId);
    }

    @Override
    public int wxbGoodCount() {
     return  mapper.selectCount();
    }
}
