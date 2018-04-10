/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.ycxy.wdgj.controller;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

/**
 * @since 2018年2月23日 下午4:06:54
 * @author hjl
 *
 */
@Component
@ServerEndpoint("/webSocket")
public class WebSocketController {
    private Session session;
    private static CopyOnWriteArraySet<WebSocketController> webSocketSet = new CopyOnWriteArraySet<WebSocketController>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
    }

    @OnClose
    public void onCLose() {
        webSocketSet.remove(this);
    }

    @OnMessage
    public void onMessage(String message) {
        sendMessage(message);
    }

    public void sendMessage(String message) {
        for (WebSocketController webSocket : webSocketSet) {
            try {
                webSocket.session.getBasicRemote().sendText("新订单！！！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
