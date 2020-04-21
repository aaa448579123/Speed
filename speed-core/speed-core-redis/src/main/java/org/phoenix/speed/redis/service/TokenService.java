package org.phoenix.speed.redis.service;


import org.phoenix.speed.redis.common.ServerResponse;
import org.phoenix.speed.redis.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

/**
 * token方法接口
 * @author yangzhenjiang
 */
public interface TokenService {
    /**
     * 创建token并返回
     * @return
     */
    ServerResponse createToken();

    /**
     * 验证token
     * @param request
     */
    void checkToken(HttpServletRequest request) throws ServiceException;
}
