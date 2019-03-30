package com.qianfeng.fxmall.goods.dao.impl;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IWxbGoodDAO;
import com.qianfeng.fxmall.goods.mapper.WxbGoodMapper;

import java.util.List;

public class WxbGoodDAOImpl implements IWxbGoodDAO {
    WxbGoodMapper mapper = MyBatisSessionFactoryUtils.getSesson().getMapper(WxbGoodMapper.class);
    @Override
    public List<WxbGood> selectWxbGoodByPage(int Page) {
        List<WxbGood> wxbGoods = mapper.selectGoodAndStu(Page, SystemConstantsUtils.Page.PAGE_SIZE);
        return wxbGoods;
    }

    @Override
    public void insertWxbGoodAndSku(WxbGood wxbGood) {
        mapper.insertWxbGoodAndSku(wxbGood);
        MyBatisSessionFactoryUtils.getSesson().commit();
    }

    @Override
    public void updateWxbGood(WxbGood wxbGood) {
        mapper.updateWxbGood(wxbGood);
    }

    @Override
    public void deleteGood(Integer goodId) {
        mapper.deleteGood(goodId);
    }

    @Override
    public int wxbGoodCount() {
        return mapper.selectCount();
    }
}
