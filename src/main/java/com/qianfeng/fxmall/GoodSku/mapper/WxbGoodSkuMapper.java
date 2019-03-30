package com.qianfeng.fxmall.GoodSku.mapper;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxbGoodSkuMapper {
    void  insertWxbGoodSku(WxbGoodSku wxbGoodSku);
    void  updateWxbGoodSku(WxbGoodSku wxbGoodSku);
    List<WxbGoodSku> wxbGoodSkuSelect(@Param("pageNo") Integer pageNo, @Param("size") Integer size);
    void wxbGoodSkuDelete(@Param("skuId") Integer skuId);
    int selectCount();
}
