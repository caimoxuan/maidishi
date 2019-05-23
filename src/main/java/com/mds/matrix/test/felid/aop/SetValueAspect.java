package com.mds.matrix.test.felid.aop;

import com.mds.matrix.test.felid.util.BeanUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cmx
 * @Date 2019/5/23 21:38
 */

@Aspect
@Component
public class SetValueAspect {


    @Autowired
    private BeanUtil beanUtil;

    @Around(value = "@annotation(com.mds.matrix.test.felid.annotion.NeedSetFelidValue)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        Object proceed = proceedingJoinPoint.proceed();
        beanUtil.SetFeild(proceed);
        return proceed;

    }


}
