package com.lialong.im.service;

import com.lialong.im.ChatRoom;
import com.lialong.im.ChatRoomContext;
import com.lialong.im.dao.RoomMapper;
import com.lialong.im.model.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private ChatRoomContext roomContext;

    public void closeRoom(String roomId) {
        roomContext.getChatRoomById(roomId).closeRoom();
    }

    public void startRoom(String roomId) {
        RoomEntity entity = roomMapper.selectByPrimaryKey(roomId);
        ChatRoom chatRoom = new ChatRoom(entity);
        roomContext.addChatRoom(chatRoom);
    }

    public List<RoomEntity> listRoom() {
        return roomMapper.selectAll();
    }

    public void addRoom(RoomEntity roomEntity) {
        roomEntity.setId("Room:" + (Math.random()*9+1)*10000);
        roomMapper.insert(roomEntity);
    }
}
