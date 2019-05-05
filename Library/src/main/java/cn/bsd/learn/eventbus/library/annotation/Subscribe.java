package cn.bsd.learn.eventbus.library.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.bsd.learn.eventbus.library.ThreadMode;

@Target(ElementType.METHOD)//注解作用在方法之上
@Retention(RetentionPolicy.RUNTIME)//jvm在运行时通过反射获取注解的值
public @interface Subscribe {
    ThreadMode threadMode() default ThreadMode.POSTING;
}
