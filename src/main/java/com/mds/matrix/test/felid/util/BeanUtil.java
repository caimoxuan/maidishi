package com.mds.matrix.test.felid.util;

import com.mds.matrix.test.felid.annotion.SetFeildValue;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cmx
 * @Date 2019/5/23 21:53
 */
@Component
public class BeanUtil implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    //这里的缓存可以用redis实现, 正式的场合需要在特定的修改方法上告知缓存跟新
    private Map<String, Object> cache = new HashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(this.applicationContext == null){
            this.applicationContext = applicationContext;
        }
    }

    public void SetFeild(Object result) throws Exception {

        if(result instanceof Collection){
            for(Object o : (Collection)result){
                Field[] fields = o.getClass().getDeclaredFields();
                for(Field f : fields){
                    SetFeildValue annotation = f.getAnnotation(SetFeildValue.class);
                    if(annotation == null){
                        continue;
                    }

                    Class clazz = annotation.clazz();

                    Method method = clazz.getMethod(annotation.method(), o.getClass().getDeclaredField(annotation.param()).getType());

                    Field param = o.getClass().getDeclaredField(annotation.param());
                    param.setAccessible( true );
                    Object paramValue = param.get(o);

                    String key = clazz.getName() + "-" + method.getName() + "-" + paramValue;

                    Object cacheValue = cache.get(key);
                    if(cacheValue != null){
                        f.setAccessible(true);
                        f.set(o, f.get(cacheValue));
                    }else{
                        Object invoke = method.invoke(applicationContext.getBean(clazz), paramValue);
                        if(invoke != null){
                            f.setAccessible(true);
                            f.set(o, f.get(invoke));
                        }
                        cache.put(key, invoke);
                    }
                }
            }
        }

        System.out.println(cache);
    }

}
