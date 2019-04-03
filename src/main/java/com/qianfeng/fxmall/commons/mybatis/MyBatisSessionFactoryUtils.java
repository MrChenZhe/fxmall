//package com.qianfeng.fxmall.commons.mybatis;
//
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.io.InputStream;
//@Component
//public class MyBatisSessionFactoryUtils {
//   // public static SqlSessionFactory sqlSessionFactory;
//    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal();
//    //静态加载
//   /* static {
//        creatSqlSessionFactory();
//    }*/
//    //创建SqlSessionFactory
//    @Bean
//    public SqlSessionFactory   creatSqlSessionFactory(){
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("MyBatis.cfg.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//            return sqlSessionFactory;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    //得到Sesson
//    @Scope("prototype")
//    @Bean
//    public static SqlSession getSesson(SqlSessionFactory slqSessionFactory){
//        SqlSession session = threadLocal.get();
//        if(session==null){
//            session=slqSessionFactory.openSession();
//            threadLocal.set(session);
//        }
//        return session;
//    }
//}
