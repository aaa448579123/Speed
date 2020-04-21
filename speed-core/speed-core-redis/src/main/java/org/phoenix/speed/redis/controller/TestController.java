package org.phoenix.speed.redis.controller;

import org.phoenix.speed.redis.annotation.ApiIdempotent;
import org.phoenix.speed.redis.common.ServerResponse;
import org.phoenix.speed.redis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 * @author yangzhenjiang
 * @version 1.0
 * @description
 * @date 2020/4/21 17:09
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @ApiIdempotent
    @PostMapping("/testIdempotence")
    public ServerResponse testIdempotence(){
        return testService.testIdempotence();
    }
}
