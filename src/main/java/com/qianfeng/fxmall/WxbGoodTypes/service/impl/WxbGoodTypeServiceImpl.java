package com.qianfeng.fxmall.WxbGoodTypes.service.impl;
import com.qianfeng.fxmall.WxbGoodTypes.bean.WxbGoodType;
import com.qianfeng.fxmall.WxbGoodTypes.dao.IWxbGoodTypeDAO;
import com.qianfeng.fxmall.WxbGoodTypes.dao.impl.WxbGoodTypeDAOImpl;
import com.qianfeng.fxmall.WxbGoodTypes.service.IWxbGoodTypeService;
import com.qianfeng.fxmall.commons.info.RandString;
import com.qianfeng.fxmall.commons.info.SystemConstantsUtils;

import java.util.List;

public class WxbGoodTypeServiceImpl implements IWxbGoodTypeService {
    IWxbGoodTypeDAO goodTypeDAO =new WxbGoodTypeDAOImpl();


    @Override
    public WxbGoodType selectGoodTypeById(String id) {
        return goodTypeDAO.selectGoodTypeById(id);
    }

    @Override
    public List<WxbGoodType> selectGoodTypeByPage(Integer pageNo) {
        return goodTypeDAO.selectGoodTypeByPage((pageNo-1)*SystemConstantsUtils.Page.PAGE_SIZE,SystemConstantsUtils.Page.PAGE_SIZE);
    }

    @Override
    public int selectGoodTypeCount() {
        return goodTypeDAO.selectGoodTypeCount();
    }

    @Override
    public List<WxbGoodType> selectAllGoodType() {
        return goodTypeDAO.selectAllGoodType();
    }

    @Override
    public void insertGoodType(WxbGoodType WxbGoodType) {
        goodTypeDAO.insertGoodType(WxbGoodType);
    }

    @Override
    public void updateGoodType(WxbGoodType WxbGoodType) {
        goodTypeDAO.updateGoodType(WxbGoodType);
    }

    @Override
    public void deleteGoodType(String typeId) {
        goodTypeDAO.deleteGoodType(typeId);
    }




}

