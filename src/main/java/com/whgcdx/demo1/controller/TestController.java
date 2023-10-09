package com.whgcdx.demo1.controller;

import com.whgcdx.demo1.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.controller
 * @className: TestController
 * @author: dx
 * @description: TODO 测试控制层
 * @date: 2023/10/7 21:57
 * @version: 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestServiceImpl testService;

    @GetMapping("/{id}")
    public String test(@PathVariable Integer id){
        System.out.println("id => " + id);
        testService.save();
        return "hello . spring boot !!!";
    }
}
