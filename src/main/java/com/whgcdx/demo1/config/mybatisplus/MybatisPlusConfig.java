package com.whgcdx.demo1.config.mybatisplus;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.whgcdx.demo1.common.handler.MetaHandler;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.config.mybatisplus
 * @className: MybatisPlusConfig
 * @author: dx
 * @description: TODO 用于配置 MybatisPlus
 * @date: 2023/10/10 21:06
 * @version: 1.0
 */

@Configuration
public class MybatisPlusConfig {

    /**
     * 自动填充功能
     *
     * @return GlobalConfig
     */
    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(MetaHandler.of());
        return globalConfig;
    }
}
