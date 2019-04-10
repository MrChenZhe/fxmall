package com.qianfeng.fxmall.WxbMemebers.VO;

public class JsonVO {
    private String suc;
    private String msg;

    public JsonVO() {
    }

    public JsonVO(String suc, String msg) {
        this.suc = suc;
        this.msg = msg;
    }

    public String getSuc() {
        return suc;
    }

    public void setSuc(String suc) {
        this.suc = suc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
