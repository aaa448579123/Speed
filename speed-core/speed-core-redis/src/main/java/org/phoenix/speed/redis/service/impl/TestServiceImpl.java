package org.phoenix.speed.redis.service.impl;

import org.phoenix.speed.redis.common.ServerResponse;
import org.phoenix.speed.redis.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author yangzhenjiang
 * @version 1.0
 * @description
 * @date 2020/4/21 17:12
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public ServerResponse testIdempotence() {
        return ServerResponse.success("testIdempotence: success");
    }
}
