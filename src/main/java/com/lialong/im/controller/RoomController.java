package com.lialong.im.controller;

import com.lialong.im.model.RoomEntity;
import com.lialong.im.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/add")
    public void addRoom(@RequestBody RoomEntity roomEntity) {
        roomService.addRoom(roomEntity);
    }

    @PostMapping("/start/{room_id}")
    public void startRoom(@PathVariable("room_id") String roomId) {
        roomService.startRoom(roomId);
    }

    @PostMapping("/close/{room_id}")
    public void stopRoom(@PathVariable("room_id") String roomId) {
        roomService.closeRoom(roomId);
    }

    @GetMapping("/all")
    List<RoomEntity> listRoom() {
        return roomService.listRoom();
    }
}
