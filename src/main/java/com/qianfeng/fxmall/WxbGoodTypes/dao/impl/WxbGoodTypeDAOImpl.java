package com.qianfeng.fxmall.WxbGoodTypes.dao.impl;

import com.qianfeng.fxmall.WxbGoodTypes.bean.WxbGoodType;
import com.qianfeng.fxmall.WxbGoodTypes.dao.IWxbGoodTypeDAO;
import com.qianfeng.fxmall.WxbGoodTypes.mapper.WxbGoodTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("WxbGoodTypeDAOImpl")
public class WxbGoodTypeDAOImpl implements IWxbGoodTypeDAO {
 @Autowired
 private WxbGoodTypeMapper wxbGoodTypeMapper;

 @Override
 public WxbGoodType selectGoodTypeById(String id) {
  WxbGoodType wxbGoodType = wxbGoodTypeMapper.selectGoodTypeById(id);
  return wxbGoodType;
 }

 @Override
 public List<WxbGoodType> selectGoodTypeByPage(Integer pageNo, Integer size) {
  List<WxbGoodType> wxbGoodTypes =wxbGoodTypeMapper.selectGoodTypeByPage(pageNo, size);
  return wxbGoodTypes;
 }

 @Override
 public int selectGoodTypeCount() {
  int count = wxbGoodTypeMapper.selectGoodTypeCount();
  return count;
 }

 @Override
 public List<WxbGoodType> selectAllGoodType() {
  List<WxbGoodType> wxbGoodTypes = wxbGoodTypeMapper.selectAllGoodType();
  return wxbGoodTypes;
 }

 @Override
 public void insertGoodType(WxbGoodType WxbGoodType) {
     wxbGoodTypeMapper.insertGoodType(WxbGoodType);

 }

 @Override
 public void updateGoodType(WxbGoodType WxbGoodType) {
     wxbGoodTypeMapper.updateGoodType(WxbGoodType);
 }

 @Override
 public void deleteGoodType(String typeId) {
     wxbGoodTypeMapper.deleteGoodType(typeId);
 }
}
