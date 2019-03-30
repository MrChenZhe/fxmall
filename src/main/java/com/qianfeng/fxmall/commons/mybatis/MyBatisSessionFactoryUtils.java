package com.qianfeng.fxmall.commons.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisSessionFactoryUtils {
    public static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal();
    //静态加载
    static {
        creatSqlSessionFactory();
    }
    //创建SqlSessionFactory
    public static void  creatSqlSessionFactory(){
        if(sqlSessionFactory==null){
            try {
                InputStream inputStream = Resources.getResourceAsStream("MyBatis.cfg.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory == null) {
            creatSqlSessionFactory();
        }
        return sqlSessionFactory;
    }
    //得到Sesson
    public static SqlSession getSesson(){
        System.out.println(Thread.currentThread().getName());
        SqlSession session = threadLocal.get();
        if(session==null){
            session=sqlSessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }
}
