package com.qianfeng.fxmall.GoodSku.mapper;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface WxbGoodSkuMapper2 {
    void  insertWxbGoodSku(WxbGoodSku wxbGoodSku);
    void  updateWxbGoodSku(WxbGoodSku wxbGoodSku);
    List<WxbGoodSku> wxbGoodSkuSelect(@Param("pageNo") Integer pageNo, @Param("size") Integer size);
    void wxbGoodSkuDelete(@Param("skuId") String skuId);
    int selectCount();
    String selectID(@Param("skuId") String sku_id);
}
