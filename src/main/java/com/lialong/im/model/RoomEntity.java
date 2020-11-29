package com.lialong.im.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@Table(name = "room")
public class RoomEntity {

    @Id
    private String id;

    private String name;

    private String status;

}
