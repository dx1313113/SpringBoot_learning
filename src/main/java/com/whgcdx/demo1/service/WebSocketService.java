package com.whgcdx.demo1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @projectName: demo1
 * @package: com.whgcdx.demo1.service
 * @className: WebSocket
 * @author: dx
 * @description: TODO 用户在线监听：请求地址实例：ws://127.0.0.1:8080/login/{USERNAME}
 * @date: 2023/10/23 21:44
 * @version: 1.0
 */
@Service
@ServerEndpoint("/login/{userId}")
@Slf4j
public class WebSocketService {
    private Session session;

    private static CopyOnWriteArraySet<WebSocketService> webSocketSet = new CopyOnWriteArraySet<>();
    private static CopyOnWriteArraySet<String> users = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(@PathParam("userId")String userId ,  Session session){
        this.session = session;
        webSocketSet.add(this);
        users.add(userId);
        log.info("【websocket 消息】 有新的连接,当前连接数：{}",webSocketSet.size());
        log.info(String.valueOf(users));

    }

    @OnClose
    public void onClose(@PathParam("userId")String userId){
        webSocketSet.remove(this);
        users.remove(userId);
        log.info("【websocket 消息】 连接断开，当前连接数：{}",webSocketSet.size());
        log.info(String.valueOf(users));
    }

    @OnMessage
    public void onMessage(@PathParam("userId")String userId , String message){
        log.info("【websocket 消息】 收到客户端【{}】的消息P:{}",userId , message);
    }

    public void sendMessage(String message){
        for(WebSocketService webSocket : webSocketSet){
            log.info("【websocket 消息】 广播消息，message = {}",message);

            try{
                webSocket.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
