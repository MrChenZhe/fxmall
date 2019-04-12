package com.qianfeng.fxmall.WxbMemebers.VO;

import org.springframework.stereotype.Component;

@Component
public class LoginVO {
    private int user_ck;
    private int ismobile;
    private int user_type;
    private String remember;
    private String captcha;
    private String username;
    private String password;

    public int getUser_ck() {
        return user_ck;
    }

    public void setUser_ck(int user_ck) {
        this.user_ck = user_ck;
    }

    public int getIsmobile() {
        return ismobile;
    }

    public void setIsmobile(int ismobile) {
        this.ismobile = ismobile;
    }

    public int getUser_type() {
        return user_type;
    }

    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginVO(int user_ck, int ismobile, int user_type, String remember, String captcha, String username, String password) {
        this.user_ck = user_ck;
        this.ismobile = ismobile;
        this.user_type = user_type;
        this.remember = remember;
        this.captcha = captcha;
        this.username = username;
        this.password = password;
    }

    public LoginVO() {
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "user_ck=" + user_ck +
                ", ismobile=" + ismobile +
                ", user_type=" + user_type +
                ", remember='" + remember + '\'' +
                ", captcha='" + captcha + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
