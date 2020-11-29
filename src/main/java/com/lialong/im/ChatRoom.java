package com.lialong.im;

import com.lialong.im.model.RoomEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatRoom {

    private RoomEntity roomEntity;

    private List<ChatSocket> webSockets = new ArrayList<>();

    public ChatRoom(RoomEntity room) {
        this.roomEntity = room;
    }

    public String getChatRoomId() {
        return roomEntity.getId();
    }

    public void addSocket(ChatSocket socket) {
        webSockets.add(socket);
    }

    public void removeSocket(ChatSocket socket) {
        webSockets.remove(socket);
    }

    public void closeRoom() {
        for (ChatSocket socket : webSockets) {
            socket.onClose();
        }
    }

    public void sendMessage(String text, String userName) throws IOException {
        for (ChatSocket websocket : webSockets) {
            websocket.sendMessage(text, userName);
        }
    }

}
