package com.qianfeng.fxmall.WxbMemebers.mapper;

import com.qianfeng.fxmall.WxbMemebers.bean.WxbMemeber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface WxbMemeberMapper {
    void insertWxbMemeber(WxbMemeber WxbMemeber);
    void updateWxbMemeber(WxbMemeber WxbMemeber);
    List<WxbMemeber> selectWxbMemeber(@Param("pageNo") int pageNo,@Param("size") int size);
    WxbMemeber selectWxbMemeberById(@Param("memeberId") String memeberId);
    int selectCount();
    WxbMemeber selectWxbMemeberAccount(@Param("account") String account);
    void deleteWxbMemeber(@Param("memeberId") String memeberId);
}
