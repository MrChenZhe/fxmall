package com.qianfeng.fxmall.goods.dao.impl;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IWxbGoodDAO;
import com.qianfeng.fxmall.goods.mapper.WxbGoodMapper;

import java.util.List;

public class WxbGoodDAOImpl implements IWxbGoodDAO {


    @Override
    public List<WxbGood> selectWxbGoodByPage(int Page) {
        WxbGoodMapper mapper = MyBatisSessionFactoryUtils.getSesson().getMapper(WxbGoodMapper.class);
        List<WxbGood> wxbGoods = mapper.selectGoodAndStu(Page, SystemConstantsUtils.Page.PAGE_SIZE);
        return wxbGoods;
    }

    @Override
    public void insertWxbGoodAndSku(WxbGood wxbGood) {
        WxbGoodMapper mapper = MyBatisSessionFactoryUtils.getSesson().getMapper(WxbGoodMapper.class);
        mapper.insertWxbGoodAndSku(wxbGood);
        MyBatisSessionFactoryUtils.getSesson().commit();
}

    @Override
    public void updateWxbGood(WxbGood wxbGood) {
        WxbGoodMapper mapper = MyBatisSessionFactoryUtils.getSesson().getMapper(WxbGoodMapper.class);
        mapper.updateWxbGood(wxbGood);
        MyBatisSessionFactoryUtils.getSesson().commit();
    }

    @Override
    public void deleteGood(Integer goodId) {
        WxbGoodMapper mapper = MyBatisSessionFactoryUtils.getSesson().getMapper(WxbGoodMapper.class);
        mapper.deleteGood(goodId);
        MyBatisSessionFactoryUtils.getSesson().commit();
    }

    @Override
    public int wxbGoodCount() {
        WxbGoodMapper mapper = MyBatisSessionFactoryUtils.getSesson().getMapper(WxbGoodMapper.class);
        return mapper.selectCount();
    }

    @Override
    public String selectGoodName(String goodName) {
        WxbGoodMapper mapper = MyBatisSessionFactoryUtils.getSesson().getMapper(WxbGoodMapper.class);
        return mapper.selectGoodName(goodName);
    }
}
