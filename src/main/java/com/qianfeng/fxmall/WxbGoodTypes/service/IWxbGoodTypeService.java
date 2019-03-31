package com.qianfeng.fxmall.WxbGoodTypes.service;

import com.qianfeng.fxmall.WxbGoodTypes.bean.WxbGoodType;
import com.qianfeng.fxmall.goods.bean.WxbGood;

import java.util.List;

public interface IWxbGoodTypeService {
    WxbGoodType selectGoodTypeById(String id);
    List<WxbGoodType> selectGoodTypeByPage(Integer pageNo);
    int selectGoodTypeCount();
    List<WxbGoodType> selectAllGoodType();
    void insertGoodType(WxbGoodType WxbGoodType);
    void updateGoodType(WxbGoodType WxbGoodType);
    void deleteGoodType(String typeId);
}
