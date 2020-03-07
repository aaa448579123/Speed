package org.phoenix.speed.controller.rest;

import org.phoenix.speed.controller.RestApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
@RestApi
public class TestController {

    @GetMapping("/b")
    public String a(){
        return "abc";
    }

    @GetMapping("/common/b")
    public String b(){
        return "bbbb";
    }

}
