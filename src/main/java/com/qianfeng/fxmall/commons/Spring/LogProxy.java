package com.qianfeng.fxmall.commons.Spring;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogProxy {
    private Logger logger=Logger.getLogger(LogProxy.class);
    @Around("execution(public * com.qianfeng.fxmall.*.service.impl.*.*(..))")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("---------------------------------------------------------------");
        Object proceed = null;
        try {
            String kind = joinPoint.getKind();
            Object[] args = joinPoint.getArgs();
            StringBuilder sb = new StringBuilder();
            for(Object o:args){
                sb.append(o.toString());
            }
            logger.debug("----------->>>kind:"+kind+"参数-->>>"+sb);
            proceed = joinPoint.proceed();
            if(proceed!=null){
                logger.debug("返回值为----->"+proceed.toString());
            }
            return proceed;
        } catch (Throwable throwable) {
            logger.debug(throwable.getMessage());
            throwable.printStackTrace();
            throw throwable;
        }
    }
}
