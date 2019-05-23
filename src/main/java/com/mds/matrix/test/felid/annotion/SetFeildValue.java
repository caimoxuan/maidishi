package com.mds.matrix.test.felid.annotion;

import java.lang.annotation.*;

/**
 * @author cmx
 * @Date 2019/5/23 21:30
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.FIELD)
public @interface SetFeildValue {

    Class clazz();

    String param();

    String method();

}
