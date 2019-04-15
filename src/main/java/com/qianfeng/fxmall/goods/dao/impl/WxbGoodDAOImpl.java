package com.qianfeng.fxmall.goods.dao.impl;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IWxbGoodDAO;
import com.qianfeng.fxmall.goods.mapper.WxbGoodMapper;
import com.qianfeng.fxmall.goods.vo.GoodAddVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("WxbGoodDAOImpl")
public class WxbGoodDAOImpl implements IWxbGoodDAO {
    @Autowired
    private WxbGoodMapper wxbGoodMapper;

    @Override
    public List<WxbGood> selectWxbGoodByPage(int Page) {
        List<WxbGood> wxbGoods = wxbGoodMapper.selectGoodAndStu(Page, SystemConstantsUtils.Page.PAGE_SIZE);
        return wxbGoods;
    }

    @Override
    public void insertWxbGoodAndSku(WxbGood wxbGood) {

        wxbGoodMapper.insertWxbGoodAndSku(wxbGood);
}

    @Override
    public void updateWxbGood(WxbGood wxbGood) {
        wxbGoodMapper.updateWxbGood(wxbGood);
    }

    @Override
    public void deleteGood(Integer goodId) {
        wxbGoodMapper.deleteGood(goodId);
    }

    @Override
    public int wxbGoodCount() {
        return wxbGoodMapper.selectCount();
    }

    @Override
    public String selectGoodName(String goodName) {
        return wxbGoodMapper.selectGoodName(goodName);
    }

    @Override
    public WxbGood selectGoodById(String goodId) {

        return wxbGoodMapper.selectGoodById(goodId);
    }

    @Override
    public void insertGoodAddVo(GoodAddVO goodAddVO) {
        wxbGoodMapper.insertGoodAddVo(goodAddVO);
    }
}
