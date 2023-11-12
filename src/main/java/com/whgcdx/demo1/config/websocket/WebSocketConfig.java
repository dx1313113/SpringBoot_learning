package com.whgcdx.demo1.config.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.config.websocket
 * @className: WebSocketConfig
 * @author: dx
 * @description: TODO
 * @date: 2023/10/23 21:41
 * @version: 1.0
 */

@Configuration
public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
