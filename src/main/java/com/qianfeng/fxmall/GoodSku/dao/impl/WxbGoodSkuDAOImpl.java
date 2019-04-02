package com.qianfeng.fxmall.GoodSku.dao.impl;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.GoodSku.dao.IWxbGoodSkuDAO;
import com.qianfeng.fxmall.GoodSku.mapper.WxbGoodSkuMapper;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
@Component("WxbGoodSkuDAOImpl")
public class WxbGoodSkuDAOImpl implements IWxbGoodSkuDAO {
@Autowired
 private SqlSession sqlSession;
    @Override
    public List<WxbGoodSku> selectWxbGoodByPage(int Page) {
     List<WxbGoodSku> wxbGoodSkus = sqlSession.getMapper(WxbGoodSkuMapper.class).wxbGoodSkuSelect(Page, SystemConstantsUtils.Page.PAGE_SIZE);
     return wxbGoodSkus;
    }

    @Override
    public void insertWxbGoodAndSku(WxbGoodSku WxbGoodSku) {
     sqlSession.getMapper(WxbGoodSkuMapper.class).insertWxbGoodSku(WxbGoodSku);
    }

    @Override
    public void updateWxbGood(WxbGoodSku WxbGoodSku) {
     sqlSession.getMapper(WxbGoodSkuMapper.class).updateWxbGoodSku(WxbGoodSku);
    }

    @Override
    public void deleteGood(Integer goodId) {
     sqlSession.getMapper(WxbGoodSkuMapper.class).wxbGoodSkuDelete(goodId);
    }

    @Override
    public int wxbGoodCount() {
     return  sqlSession.getMapper(WxbGoodSkuMapper.class).selectCount();
    }
    @Override
    public String selectID(String sku_id) {
     return sqlSession.getMapper(WxbGoodSkuMapper.class).selectID(sku_id);
    }
}
