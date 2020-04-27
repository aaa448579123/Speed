package org.phoenix.speed.redis.interceptor;

import org.phoenix.speed.redis.annotation.AccessLimit;
import org.phoenix.speed.redis.common.Constant;
import org.phoenix.speed.redis.common.ResponseCode;
import org.phoenix.speed.redis.exception.ServiceException;
import org.phoenix.speed.redis.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * 接口防刷限流拦截器
 * @author yangzhenjiang
 * @date 2020/4/27 11:15
 */
public class AccessLimitInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        //若为HandlerMethod下一步，不是返回true
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        AccessLimit annotation = method.getAnnotation(AccessLimit.class);
        if(annotation != null){
            check(annotation,request);
        }

        return true;
    }

    private void check(AccessLimit annotation, HttpServletRequest request){
        int maxCount = annotation.maxCount();
        int seconds = annotation.seconds();

        StringBuilder sb = new StringBuilder();
        sb.append(Constant.Redis.ACCESS_LIMIT_PREFIX).append(IpUtil.getIpAddress(request)).append(request.getRequestURI());
        String key = sb.toString();

        Boolean exists = redisTemplate.hasKey(key);
        if(!exists){
            redisTemplate.opsForValue().set(key,String.valueOf(1),seconds,TimeUnit.SECONDS);
        }else {
            int count = Integer.valueOf((String) redisTemplate.opsForValue().get(key));
            if (count < maxCount){
                Long ttl = redisTemplate.opsForValue().getOperations().getExpire(key);
                if(ttl < 0){
                    redisTemplate.opsForValue().set(key,String.valueOf(1),seconds,TimeUnit.SECONDS);
                }else {
                    redisTemplate.opsForValue().set(key,String.valueOf(++count),ttl.intValue(),TimeUnit.SECONDS);
                }
            }else {
                throw new ServiceException(ResponseCode.ACCESS_LIMIT.getMsg());
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
