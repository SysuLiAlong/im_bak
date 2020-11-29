package com.lialong.im;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class ChatRoomContext {

    private ConcurrentHashMap<String, ChatRoom> onLineChatRoom = new ConcurrentHashMap<>();

    public void addChatRoom(ChatRoom chatRoom) {
        onLineChatRoom.put(chatRoom.getChatRoomId(), chatRoom);
    }

    public void leaveChatRoom(ChatRoom chatRoom) {
        onLineChatRoom.remove(chatRoom.getChatRoomId());
    }

    public ChatRoom getChatRoomById(String roomId) {
        return onLineChatRoom.get(roomId);
    }

}
