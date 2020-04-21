package org.phoenix.speed.redis.controller;

import org.phoenix.speed.redis.common.ServerResponse;
import org.phoenix.speed.redis.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * token控制层
 * @author yangzhenjiang
 * @version 1.0
 * @description
 * @date 2020/4/21 17:06
 */
@RestController
@RequestMapping("/token")
public class TokenContrller {
    @Autowired
    private TokenService tokenService;

    @GetMapping("/getToken")
    public ServerResponse token(){
        return tokenService.createToken();
    }
}
