package com.qianfeng.fxmall.WxbGoodTypes.mapper;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import com.qianfeng.fxmall.WxbGoodTypes.bean.WxbGoodType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxbGoodTypeMapper {
    WxbGoodType selectGoodTypeById(@Param("typeId") String id);
    List<WxbGoodType> selectGoodTypeByPage(@Param("pageNo") Integer pageNo,@Param("size") Integer size);
    int selectGoodTypeCount();
    List<WxbGoodType> selectAllGoodType();
    void insertGoodType(WxbGoodType WxbGoodType);
    void updateGoodType(WxbGoodType WxbGoodType);
    void deleteGoodType(@Param("typeId") String typeId);

}
