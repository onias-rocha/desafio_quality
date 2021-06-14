package com.digitalhouse.desafioquality.rest.dto;

import com.digitalhouse.desafioquality.entity.Room;
import lombok.Data;

@Data
public class RoomDTO {
    private String room_name;
    private Double room_width;
    private Double room_length;

    public Room turnIntoRoom(){
        Room room = new Room();
        room.setName(room_name);
        room.setWidth(room_width);
        room.setLength(room_length);

        return room;
    }
}
