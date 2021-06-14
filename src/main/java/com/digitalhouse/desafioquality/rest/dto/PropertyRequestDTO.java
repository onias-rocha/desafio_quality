package com.digitalhouse.desafioquality.rest.dto;

import com.digitalhouse.desafioquality.entity.District;
import com.digitalhouse.desafioquality.entity.Property;
import com.digitalhouse.desafioquality.entity.Room;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PropertyRequestDTO {
    private String prop_name;
    private String prop_district;
    private List<RoomDTO> rooms;

    public Property turnIntoProperty(){
        Property p1 = new Property();

        p1.setName(prop_name);
        p1.setDistrict(new District(prop_district));
        List<Room> listOfRooms = new ArrayList<>();
        for(RoomDTO dto : rooms){
            listOfRooms.add(dto.turnIntoRoom());
        }
        p1.setRooms(listOfRooms);

        return p1;
    }
}




