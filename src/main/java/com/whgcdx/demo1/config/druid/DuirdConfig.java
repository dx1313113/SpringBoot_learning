package com.whgcdx.demo1.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.config.druid
 * @className: DuirdConfig
 * @author: dx
 * @description: TODO 用于配置数据库连接池
 * @date: 2023/10/8 19:12
 * @version: 1.0
 */

@Configuration
public class DuirdConfig {
    /**
     * 添加 DruidDataSource 组件到容器中，并绑定属性
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    @ConditionalOnProperty(name = "spring.datasource.type", havingValue = "com.alibaba.druid.pool.DruidDataSource")
    public DataSource druid(){
        return  new DruidDataSource();
    }
}
