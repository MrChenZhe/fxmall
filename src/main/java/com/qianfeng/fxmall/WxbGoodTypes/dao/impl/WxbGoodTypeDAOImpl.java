package com.qianfeng.fxmall.WxbGoodTypes.dao.impl;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.WxbGoodTypes.bean.WxbGoodType;
import com.qianfeng.fxmall.WxbGoodTypes.dao.IWxbGoodTypeDAO;
import com.qianfeng.fxmall.WxbGoodTypes.mapper.WxbGoodTypeMapper;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("WxbGoodTypeDAOImpl")
public class WxbGoodTypeDAOImpl implements IWxbGoodTypeDAO {
 @Autowired
 private SqlSession sqlSession;

 @Override
 public WxbGoodType selectGoodTypeById(String id) {
  WxbGoodType wxbGoodType = sqlSession.getMapper(WxbGoodTypeMapper.class).selectGoodTypeById(id);
  return wxbGoodType;
 }

 @Override
 public List<WxbGoodType> selectGoodTypeByPage(Integer pageNo, Integer size) {
  List<WxbGoodType> wxbGoodTypes =sqlSession.getMapper(WxbGoodTypeMapper.class).selectGoodTypeByPage(pageNo, size);
  return wxbGoodTypes;
 }

 @Override
 public int selectGoodTypeCount() {
  int count = sqlSession.getMapper(WxbGoodTypeMapper.class).selectGoodTypeCount();
  return count;
 }

 @Override
 public List<WxbGoodType> selectAllGoodType() {
  List<WxbGoodType> wxbGoodTypes = sqlSession.getMapper(WxbGoodTypeMapper.class).selectAllGoodType();
  return wxbGoodTypes;
 }

 @Override
 public void insertGoodType(WxbGoodType WxbGoodType) {
  sqlSession.getMapper(WxbGoodTypeMapper.class).insertGoodType(WxbGoodType);
  sqlSession.commit();

 }

 @Override
 public void updateGoodType(WxbGoodType WxbGoodType) {
  sqlSession.getMapper(WxbGoodTypeMapper.class).updateGoodType(WxbGoodType);
  sqlSession.commit();
 }

 @Override
 public void deleteGoodType(String typeId) {
  sqlSession.getMapper(WxbGoodTypeMapper.class).deleteGoodType(typeId);
  sqlSession.commit();
 }


}
