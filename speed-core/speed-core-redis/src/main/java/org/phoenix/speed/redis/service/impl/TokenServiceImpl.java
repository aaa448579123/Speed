package org.phoenix.speed.redis.service.impl;
import org.apache.commons.lang3.StringUtils;
import org.phoenix.speed.redis.common.Constant;
import org.phoenix.speed.redis.common.ResponseCode;
import org.phoenix.speed.redis.common.ServerResponse;
import org.phoenix.speed.redis.exception.ServiceException;
import org.phoenix.speed.redis.service.TokenService;
import org.phoenix.speed.redis.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yangzhenjiang
 * @version 1.0
 * @description
 * @date 2020/4/21 16:08
 */
@Service
public class TokenServiceImpl implements TokenService {

    private static final String TOKEN_NAME = "token";

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ServerResponse createToken() {
        //生成包含大、小写字母、数字的字符串
        String str = RandomUtil.generateStr(24);
        StringBuffer token = new StringBuffer();
        //生成token
        token.append(Constant.Redis.TOKEN_PREFIX).append(str);
        //将token存入Redis中设置过期时间
        redisTemplate.opsForValue().set(token.toString(),token.toString(),Constant.Redis.EXPIRE_TIME_MINUTE);
        //返回指定格式的请求
        return ServerResponse.success(token.toString());
    }

    @Override
    public void checkToken(HttpServletRequest request) throws ServiceException {
        String token = request.getHeader(TOKEN_NAME);
        //header中不存在token
        if (StringUtils.isBlank(token)){
            token = request.getParameter(TOKEN_NAME);
            //parameter中也不存在token
            if (StringUtils.isBlank(token)){
                throw new ServiceException(ResponseCode.ILLEGAL_ARGUMENT.getMsg());
            }
        }
        //如果Redis中不存在该token
        if (!redisTemplate.hasKey(token)){
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
        //删除Redis中token
        Boolean del = redisTemplate.delete(token);
        if (!del){
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
    }
}
