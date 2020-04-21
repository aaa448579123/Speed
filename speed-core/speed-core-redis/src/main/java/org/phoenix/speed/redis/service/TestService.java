package org.phoenix.speed.redis.service;

import org.phoenix.speed.redis.common.ServerResponse;

/**
 * @author yangzhenjiang
 * @version 1.0
 * @description
 * @date 2020/4/21 17:11
 */
public interface TestService {

    ServerResponse testIdempotence();
}
