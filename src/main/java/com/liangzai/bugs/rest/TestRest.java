package com.liangzai.bugs.rest;

import com.liangzai.bugs.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author liangzaixiaoxia
 * @Date 2023/4/17
 * @Description 测试用用
 */
@RestController
@RequestMapping("test")
public class TestRest {

    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public String test() {
        return testService.test();
    }
}
