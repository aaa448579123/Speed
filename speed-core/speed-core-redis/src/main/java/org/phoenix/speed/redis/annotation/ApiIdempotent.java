package org.phoenix.speed.redis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在需要保证接口幂等性的Controller的方法上使用此注解
 * @author yangzhenjiang
 * @version 1.0
 * @description
 * @date 2020/4/21 16:02
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiIdempotent {
}
