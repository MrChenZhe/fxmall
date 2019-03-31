package com.qianfeng.fxmall.goods.mapper;

import com.qianfeng.fxmall.goods.bean.WxbGood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxbGoodMapper {
    void  insertWxbGoodAndSku(WxbGood wxbGood);
    void  updateWxbGood(WxbGood wxbGood);
    List<WxbGood> selectGoodAndStu(@Param("pageNo") Integer pageNo,@Param("size") Integer size);
    void deleteGood(@Param("goodId") Integer goodId);
    int selectCount();
    String selectGoodName(@Param("goodId") String goodId);
}

