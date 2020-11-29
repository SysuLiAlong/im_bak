package com.lialong.im;

import com.lialong.im.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Component
@ServerEndpoint("/websocket/{roomId}/{userName}")
public class ChatSocket {

    private static ChatRoomContext chatRoomContext;

    private ChatRoom chatRoom;

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private String roomId;

    private String userName;

    @Autowired
    public void setChatRoomContext(ChatRoomContext chatRoomContext) {
        ChatSocket.chatRoomContext = chatRoomContext;
    }

    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(@PathParam("roomId") String roomId, @PathParam("userName") String userName, Session session) {
        this.session = session;
        this.chatRoom = chatRoomContext.getChatRoomById(roomId);
        this.roomId = roomId;
        this.userName = userName;
        enterChatRoom();
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        leaveChatRoom();
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        chatRoom.sendMessage(message, this.userName);
    }

    public void sendMessage(String message, String userName) throws IOException {
//        this.session.getBasicRemote().sendText(message);
        this.session.getAsyncRemote().sendText(userName + ":" + message);
    }

    public void enterChatRoom() {
        chatRoom.addSocket(this);
    }

    public void leaveChatRoom() {
        chatRoom.removeSocket(this);
    }

}