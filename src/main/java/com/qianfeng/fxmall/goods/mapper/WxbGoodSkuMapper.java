package com.qianfeng.fxmall.goods.mapper;

import com.qianfeng.fxmall.goods.bean.WxbGoodSku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WxbGoodSkuMapper {
    void  insertWxbGoodSku(WxbGoodSku wxbGoodSku);
    void  updateWxbGoodSku(WxbGoodSku wxbGoodSku);
    List<WxbGoodSku> wxbGoodSkuSelect(@Param("pageNo") Integer pageNo, @Param("size") Integer size);
    void wxbGoodSkuDelete(@Param("skuId") Integer skuId);
}
