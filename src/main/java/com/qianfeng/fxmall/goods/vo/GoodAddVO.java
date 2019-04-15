package com.qianfeng.fxmall.goods.vo;

import com.qianfeng.fxmall.GoodSku.bean.WxbGoodSku;

import java.sql.Timestamp;

public class GoodAddVO {
    private String good_id;
    private String good_name;
    private String customerId;
    private String goodPic;
    private String goodPic1;
    private String goodPic2;
    private String promote_desc;
    private String sku_title;
    private String sku_cost;
    private String sku_price;
    private String sku_pmoney;
    private String copy_id;
    private String copy_desc;
    private String forward_link;
    private long order_no;
    private String type_id;
    private String tags;
    private long state;
    private java.sql.Timestamp createTime;
    private long toped;
    private long recomed;
    private java.sql.Timestamp topedTime;
    private java.sql.Timestamp recomedTime;
    private String spc_id;
    private String zon_id;
    private long sell_num;
    private String website;
    private long iswxpay;
    private long isfdfk;
    private long leixingId;
    private String kfqq;
    private String service_money;
    private String sku_str;

    @Override
    public String toString() {
        return "GoodAddVO{" +
                "good_id='" + good_id + '\'' +
                ", good_name='" + good_name + '\'' +
                ", customerId='" + customerId + '\'' +
                ", goodPic='" + goodPic + '\'' +
                ", goodPic1='" + goodPic1 + '\'' +
                ", goodPic2='" + goodPic2 + '\'' +
                ", promote_desc='" + promote_desc + '\'' +
                ", sku_title='" + sku_title + '\'' +
                ", sku_cost='" + sku_cost + '\'' +
                ", sku_price='" + sku_price + '\'' +
                ", sku_pmoney='" + sku_pmoney + '\'' +
                ", copy_id='" + copy_id + '\'' +
                ", copy_desc='" + copy_desc + '\'' +
                ", forward_link='" + forward_link + '\'' +
                ", order_no=" + order_no +
                ", type_id='" + type_id + '\'' +
                ", tags='" + tags + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", toped=" + toped +
                ", recomed=" + recomed +
                ", topedTime=" + topedTime +
                ", recomedTime=" + recomedTime +
                ", spc_id='" + spc_id + '\'' +
                ", zon_id='" + zon_id + '\'' +
                ", sell_num=" + sell_num +
                ", website='" + website + '\'' +
                ", iswxpay=" + iswxpay +
                ", isfdfk=" + isfdfk +
                ", leixingId=" + leixingId +
                ", kfqq='" + kfqq + '\'' +
                ", service_money='" + service_money + '\'' +
                ", sku_str='" + sku_str + '\'' +
                '}';
    }

    public String getService_money() {
        return service_money;
    }

    public void setService_money(String service_money) {
        this.service_money = service_money;
    }

    public String getGood_id() {
        return good_id;
    }

    public void setGood_id(String good_id) {
        this.good_id = good_id;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getGoodPic() {
        return goodPic;
    }

    public void setGoodPic(String goodPic) {
        this.goodPic = goodPic;
    }

    public String getGoodPic1() {
        return goodPic1;
    }

    public void setGoodPic1(String goodPic1) {
        this.goodPic1 = goodPic1;
    }

    public String getGoodPic2() {
        return goodPic2;
    }

    public void setGoodPic2(String goodPic2) {
        this.goodPic2 = goodPic2;
    }

    public String getPromote_desc() {
        return promote_desc;
    }

    public void setPromote_desc(String promote_desc) {
        this.promote_desc = promote_desc;
    }

    public String getSku_title() {
        return sku_title;
    }

    public void setSku_title(String sku_title) {
        this.sku_title = sku_title;
    }

    public String getSku_cost() {
        return sku_cost;
    }

    public void setSku_cost(String sku_cost) {
        this.sku_cost = sku_cost;
    }

    public String getSku_price() {
        return sku_price;
    }

    public void setSku_price(String sku_price) {
        this.sku_price = sku_price;
    }

    public String getSku_pmoney() {
        return sku_pmoney;
    }

    public void setSku_pmoney(String sku_pmoney) {
        this.sku_pmoney = sku_pmoney;
    }

    public String getCopy_id() {
        return copy_id;
    }

    public void setCopy_id(String copy_id) {
        this.copy_id = copy_id;
    }

    public String getCopy_desc() {
        return copy_desc;
    }

    public void setCopy_desc(String copy_desc) {
        this.copy_desc = copy_desc;
    }

    public String getForward_link() {
        return forward_link;
    }

    public void setForward_link(String forward_link) {
        this.forward_link = forward_link;
    }

    public long getOrder_no() {
        return order_no;
    }

    public void setOrder_no(long order_no) {
        this.order_no = order_no;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public long getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public long getToped() {
        return toped;
    }

    public void setToped(long toped) {
        this.toped = toped;
    }

    public long getRecomed() {
        return recomed;
    }

    public void setRecomed(long recomed) {
        this.recomed = recomed;
    }

    public Timestamp getTopedTime() {
        return topedTime;
    }

    public void setTopedTime(Timestamp topedTime) {
        this.topedTime = topedTime;
    }

    public Timestamp getRecomedTime() {
        return recomedTime;
    }

    public void setRecomedTime(Timestamp recomedTime) {
        this.recomedTime = recomedTime;
    }

    public String getSpc_id() {
        return spc_id;
    }

    public void setSpc_id(String spc_id) {
        this.spc_id = spc_id;
    }

    public String getZon_id() {
        return zon_id;
    }

    public void setZon_id(String zon_id) {
        this.zon_id = zon_id;
    }

    public long getSell_num() {
        return sell_num;
    }

    public void setSell_num(long sell_num) {
        this.sell_num = sell_num;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public long getIswxpay() {
        return iswxpay;
    }

    public void setIswxpay(long iswxpay) {
        this.iswxpay = iswxpay;
    }

    public long getIsfdfk() {
        return isfdfk;
    }

    public void setIsfdfk(long isfdfk) {
        this.isfdfk = isfdfk;
    }

    public long getLeixingId() {
        return leixingId;
    }

    public void setLeixingId(long leixingId) {
        this.leixingId = leixingId;
    }

    public String getKfqq() {
        return kfqq;
    }

    public void setKfqq(String kfqq) {
        this.kfqq = kfqq;
    }

    public String getSku_str() {
        return sku_str;
    }

    public void setSku_str(String sku_str) {
        this.sku_str = sku_str;
    }

    public GoodAddVO() {
    }

    public GoodAddVO(String good_id, String good_name, String customerId, String goodPic, String goodPic1, String goodPic2, String promote_desc, String sku_title, String sku_cost, String sku_price, String sku_pmoney, String copy_id, String copy_desc, String forward_link, long order_no, String type_id, String tags, long state, Timestamp createTime, long toped, long recomed, Timestamp topedTime, Timestamp recomedTime, String spc_id, String zon_id, long sell_num, String website, long iswxpay, long isfdfk, long leixingId, String kfqq, String service_money, String sku_str) {
        this.good_id = good_id;
        this.good_name = good_name;
        this.customerId = customerId;
        this.goodPic = goodPic;
        this.goodPic1 = goodPic1;
        this.goodPic2 = goodPic2;
        this.promote_desc = promote_desc;
        this.sku_title = sku_title;
        this.sku_cost = sku_cost;
        this.sku_price = sku_price;
        this.sku_pmoney = sku_pmoney;
        this.copy_id = copy_id;
        this.copy_desc = copy_desc;
        this.forward_link = forward_link;
        this.order_no = order_no;
        this.type_id = type_id;
        this.tags = tags;
        this.state = state;
        this.createTime = createTime;
        this.toped = toped;
        this.recomed = recomed;
        this.topedTime = topedTime;
        this.recomedTime = recomedTime;
        this.spc_id = spc_id;
        this.zon_id = zon_id;
        this.sell_num = sell_num;
        this.website = website;
        this.iswxpay = iswxpay;
        this.isfdfk = isfdfk;
        this.leixingId = leixingId;
        this.kfqq = kfqq;
        this.service_money = service_money;
        this.sku_str = sku_str;
    }
}
