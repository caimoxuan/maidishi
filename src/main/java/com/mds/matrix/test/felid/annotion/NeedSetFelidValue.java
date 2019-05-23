package com.mds.matrix.test.felid.annotion;

import java.lang.annotation.*;

/**
 * @author cmx
 * @Date 2019/5/23 21:37
 */


@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface NeedSetFelidValue {
}
