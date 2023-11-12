package com.whgcdx.demo1.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.handler
 * @className: WebSocketInterceptor
 * @author: dx
 * @description: TODO
 * @date: 2023/11/8 21:07
 * @version: 1.0
 */

@Component
public class WebSocketInterceptor implements HandlerInterceptor {
    @Value("${server.port}")
    private String port;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String username = request.getParameter("username");
        String websocketURL = "ws://127.0.0.1:" + port + "/" + username;
        StandardWebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketSession session = webSocketClient.doHandshake(new MyWebsocketHandler(), new WebSocketHttpHeaders(), new URI(websocketURL)).get();
        session.sendMessage(new TextMessage(username + "已上线"));
    }
}
