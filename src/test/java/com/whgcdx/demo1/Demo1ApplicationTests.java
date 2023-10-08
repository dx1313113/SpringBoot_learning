package com.whgcdx.demo1;

import com.whgcdx.demo1.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1ApplicationTests {

    @Autowired
    private TestService testService;
    @Test
    public void  save(){
        testService.save();
    }

}
