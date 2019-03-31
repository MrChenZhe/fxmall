package com.qianfeng.fxmall.WxbGoodTypes.dao.impl;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.WxbGoodTypes.bean.WxbGoodType;
import com.qianfeng.fxmall.WxbGoodTypes.dao.IWxbGoodTypeDAO;
import com.qianfeng.fxmall.WxbGoodTypes.mapper.WxbGoodTypeMapper;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;
import com.qianfeng.fxmall.commons.mybatis.MyBatisSessionFactoryUtils;

import java.util.List;

public class WxbGoodTypeDAOImpl implements IWxbGoodTypeDAO {
   WxbGoodTypeMapper mapper = MyBatisSessionFactoryUtils.getSesson().getMapper(WxbGoodTypeMapper.class);


 @Override
 public WxbGoodType selectGoodTypeById(String id) {
  WxbGoodType wxbGoodType = mapper.selectGoodTypeById(id);
  return wxbGoodType;
 }

 @Override
 public List<WxbGoodType> selectGoodTypeByPage(Integer pageNo, Integer size) {
  List<WxbGoodType> wxbGoodTypes = mapper.selectGoodTypeByPage(pageNo, size);
  return wxbGoodTypes;
 }

 @Override
 public int selectGoodTypeCount() {
  int count = mapper.selectGoodTypeCount();
  return count;
 }

 @Override
 public List<WxbGoodType> selectAllGoodType() {
  List<WxbGoodType> wxbGoodTypes = mapper.selectAllGoodType();
  return wxbGoodTypes;
 }

 @Override
 public void insertGoodType(WxbGoodType WxbGoodType) {
  mapper.insertGoodType(WxbGoodType);
  MyBatisSessionFactoryUtils.getSesson().commit();

 }

 @Override
 public void updateGoodType(WxbGoodType WxbGoodType) {
   mapper.updateGoodType(WxbGoodType);
  MyBatisSessionFactoryUtils.getSesson().commit();
 }

 @Override
 public void deleteGoodType(String typeId) {
    mapper.deleteGoodType(typeId);
  MyBatisSessionFactoryUtils.getSesson().commit();
 }
}
