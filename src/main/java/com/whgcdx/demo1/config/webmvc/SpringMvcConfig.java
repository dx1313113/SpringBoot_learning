package com.whgcdx.demo1.config.webmvc;

import com.whgcdx.demo1.handler.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.config.webmvc
 * @className: SpringMvcConfig
 * @author: dx
 * @description: TODO springmvc 配置类 暂未实现拦截功能
 * @date: 2023/10/7 14:14
 * @version: 1.0
 */

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

//    添加拦截器
    @Autowired
    private ProjectInterceptor projectInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/暂不实现");
    }
}
