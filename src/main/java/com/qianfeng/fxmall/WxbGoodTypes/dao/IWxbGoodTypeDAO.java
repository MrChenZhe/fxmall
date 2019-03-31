package com.qianfeng.fxmall.WxbGoodTypes.dao;


import com.qianfeng.fxmall.WxbGoodTypes.bean.WxbGoodType;

import java.util.List;

public interface IWxbGoodTypeDAO {
    WxbGoodType selectGoodTypeById(String id);
    List<WxbGoodType> selectGoodTypeByPage(Integer pageNo,Integer size);
    int selectGoodTypeCount();
    List<WxbGoodType> selectAllGoodType();
    void insertGoodType(WxbGoodType WxbGoodType);
    void updateGoodType(WxbGoodType WxbGoodType);
    void deleteGoodType(String typeId);
}
