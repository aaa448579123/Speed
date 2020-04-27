package org.phoenix.speed.redis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在需要保证 接口防刷限流的 controller的方法上使用此注解
 * @author yangzhenjiang
 * @date 2020/4/27
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLimit {
    //最大访问次数
    int maxCount();

    //固定时间，单位：秒S
    int seconds();
}
