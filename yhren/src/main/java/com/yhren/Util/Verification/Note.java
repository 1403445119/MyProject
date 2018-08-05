package com.yhren.Util.Verification;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Note {
    boolean notNull() default true; //是否能为空默认不能为空
    int type() default 0;   //类型 默认为0不进行正则校验
    String name();  //校验时使用的名称
}
