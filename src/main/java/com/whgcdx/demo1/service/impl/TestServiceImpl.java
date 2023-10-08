package com.whgcdx.demo1.service.impl;

import com.whgcdx.demo1.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.service.impl
 * @className: TestServiceImpl
 * @author: dx
 * @description: TODO
 * @date: 2023/10/8 16:11
 * @version: 1.0
 */

@Service
public class TestServiceImpl implements TestService {

    @Override
    public void save() {
        System.out.println("Test Service Running");
    }
}
