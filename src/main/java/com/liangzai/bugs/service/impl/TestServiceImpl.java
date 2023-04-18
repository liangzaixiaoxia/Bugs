package com.liangzai.bugs.service.impl;

import com.liangzai.bugs.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @Author liangzaixiaoxia
 * @Date 2023/4/17
 * @Description -
 */

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String test() {
        return "the test";
    }
}
