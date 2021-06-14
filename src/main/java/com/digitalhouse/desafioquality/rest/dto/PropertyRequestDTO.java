package com.digitalhouse.desafioquality.rest.dto;

import com.digitalhouse.desafioquality.entity.District;
import com.digitalhouse.desafioquality.entity.Property;
import com.digitalhouse.desafioquality.entity.Room;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class PropertyRequestDTO {
    @NotNull(message = "O nome da propriedade não pode estar vazio.")
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

    public PropertyRequestDTO(@NonNull String prop_name, String prop_district, List<RoomDTO> rooms) {
        this.prop_name = prop_name;
        this.prop_district = prop_district;
        this.rooms = rooms;
    }

    public PropertyRequestDTO() {
    }
}




