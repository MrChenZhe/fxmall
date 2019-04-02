package com.qianfeng.fxmall.goods.dao.impl;

import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryUtils;
import com.qianfeng.fxmall.goods.bean.WxbGood;
import com.qianfeng.fxmall.goods.dao.IWxbGoodDAO;
import com.qianfeng.fxmall.goods.mapper.WxbGoodMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("WxbGoodDAOImpl")
public class WxbGoodDAOImpl implements IWxbGoodDAO {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<WxbGood> selectWxbGoodByPage(int Page) {
        WxbGoodMapper mapper = sqlSession.getMapper(WxbGoodMapper.class);
        List<WxbGood> wxbGoods = mapper.selectGoodAndStu(Page, SystemConstantsUtils.Page.PAGE_SIZE);
        return wxbGoods;
    }

    @Override
    public void insertWxbGoodAndSku(WxbGood wxbGood) {
        WxbGoodMapper mapper = sqlSession.getMapper(WxbGoodMapper.class);
        mapper.insertWxbGoodAndSku(wxbGood);
        sqlSession.commit();
}

    @Override
    public void updateWxbGood(WxbGood wxbGood) {
        WxbGoodMapper mapper = sqlSession.getMapper(WxbGoodMapper.class);
        mapper.updateWxbGood(wxbGood);
        sqlSession.commit();
    }

    @Override
    public void deleteGood(Integer goodId) {
        WxbGoodMapper mapper = sqlSession.getMapper(WxbGoodMapper.class);
        mapper.deleteGood(goodId);
        sqlSession.commit();
    }

    @Override
    public int wxbGoodCount() {
        WxbGoodMapper mapper = sqlSession.getMapper(WxbGoodMapper.class);
        return mapper.selectCount();
    }

    @Override
    public String selectGoodName(String goodName) {
        WxbGoodMapper mapper = sqlSession.getMapper(WxbGoodMapper.class);
        return mapper.selectGoodName(goodName);
    }
}
