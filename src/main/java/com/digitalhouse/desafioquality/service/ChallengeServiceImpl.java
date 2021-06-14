package com.digitalhouse.desafioquality.service;

import com.digitalhouse.desafioquality.entity.District;
import com.digitalhouse.desafioquality.entity.Property;
import com.digitalhouse.desafioquality.entity.Room;
import com.digitalhouse.desafioquality.repository.PropertyRepository;
import com.digitalhouse.desafioquality.rest.dto.PropertyRequestDTO;
import com.digitalhouse.desafioquality.rest.dto.RoomDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    PropertyRepository repository;

    public ChallengeServiceImpl(PropertyRepository repository) {
        this.repository = repository;
    }

    public void validateInput(PropertyRequestDTO property){
        if(property.getProp_name() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome da propriedade não pode estar vazio.");
        }


        String name = property.getProp_name();
        String received = name.substring(0,1);
        String lowerCase =received.toLowerCase(Locale.ROOT);

        boolean invalidRoomName = false;
        boolean nullRoomName = false;
        boolean invalidRoomNameLength = false;
        boolean invalidRoomWidthSize= false;
        boolean nullRoomWidth = false;
        boolean nullRoomLength = false;
        boolean invalidRoomLengthSize = false;

        for(RoomDTO room : property.getRooms()){
            if(room.getRoom_name() == null){
                nullRoomName = true;
            } else
            if(room.getRoom_width() == null){
                nullRoomWidth = true;
            } else
            if(room.getRoom_length() == null){
                nullRoomLength = true;
            } else
            if(room.getRoom_length() > 33){
                invalidRoomLengthSize = true;
            } else
            if(room.getRoom_name().length()>30){
                invalidRoomNameLength = true;
            } else
            if(room.getRoom_width() > 25){
                invalidRoomWidthSize = true;
            } else {
                String roomName = room.getRoom_name();
                String roomReceived = roomName.substring(0,1);
                String roomLowerCase = roomReceived.toLowerCase(Locale.ROOT);
                if (roomReceived.equals(roomLowerCase)){
                    invalidRoomName = true;
                }
            }
        }

        if(received.equals(lowerCase)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O primeiro digito da propriedade não pode ser minúsculo.");
        }
        if(name.length()>30){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome não pode exceder 30 caracteres.");
        }
        if(property.getProp_district() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O bairo não pode estar vazio.");
        }

        if(property.getProp_district() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O bairro não pode estar vazio.");
        }
        if(property.getProp_district().length()>45){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O comprimento do bairro não pode exceder 45 caracteres.");
        }

        if(invalidRoomName){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome do cômodo deve começar com uma letra maiúscula.");
        }
        if(nullRoomName){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo [room_name] não pode estar vazio.");
        }
        if(invalidRoomNameLength){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O comprimento do cômodo não pode exceder 30 caracteres.");
        }

        if(invalidRoomWidthSize){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A largura máxima permitida por cômodo é de 25 metros");
        }

        if(nullRoomWidth){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A largura do cômodo não pode estar vazia.");
        }

        if(nullRoomLength){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O comprimento do cômodo não pode estar vazio");
        }

        if(invalidRoomLengthSize){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O comprimento máximo permitido por cômodo é de 33 metros.");
        }

    }

    @Override
    public District auxDistrictValues(District district) {
        List<District> availableDistricts = repository.getAllDistricts();
        District found = null;
        for(District d1 : availableDistricts){
            if(d1.getName().toLowerCase(Locale.ROOT).equals(district.getName().toLowerCase(Locale.ROOT))){
                found = d1;
            }
        }
        return found;
    }

    @Override
    public Double calculateSquareMeters(PropertyRequestDTO property) {
        validateInput(property);
        return repository.getPropertiesSquareMeters(property.turnIntoProperty());
    }

    @Override
    public Double calculatePropertyValue(PropertyRequestDTO property) {
        validateInput(property);
        Property prop = property.turnIntoProperty();
        District d1 = auxDistrictValues(prop.getDistrict());
        return calculateSquareMeters(property) * d1.getPricePerSquareMeter();
    }

    @Override
    public Room calculateBiggestRoom(PropertyRequestDTO property) {
        validateInput(property);
        Property prop = property.turnIntoProperty();
        List<Room> rooms = prop.getRooms();

        Room bigger = null;

        for(Room room: rooms){
            if (bigger == null){
                bigger = room;
            }else if((room.getWidth() * room.getLength()) > bigger.getWidth() * bigger.getLength()){
                bigger = room;
            }
        }
        return bigger;
    }

    @Override
    public ArrayList<Double> calculateAllRoomsSquareMeters(PropertyRequestDTO property) {
        validateInput(property);
        ArrayList<Double> roomsSquareMeters = new ArrayList<>();

        for(RoomDTO room: property.getRooms()){
            roomsSquareMeters.add(room.getRoom_length() * room.getRoom_width());
        }

        return roomsSquareMeters;
    }

    @Override
    public ArrayList<RoomResponseDTO> calculateAllRoomsSquareMetersRestfully(PropertyRequestDTO property) {
        validateInput(property);

        ArrayList<RoomResponseDTO> ListOfRoomsResponseDtos = new ArrayList<>();

        List<RoomDTO> dtoOfRooms = property.getRooms();
        List<Double> squareMeters = calculateAllRoomsSquareMeters(property);

        for(int i = 0; i<property.getRooms().size(); i++){
            RoomResponseDTO RoomResponseDto = new RoomResponseDTO();
            RoomResponseDto.setRoomName(dtoOfRooms.get(i).getRoom_name());
            RoomResponseDto.setSquareMeter(squareMeters.get(i));
            ListOfRoomsResponseDtos.add(RoomResponseDto);
        }

        return ListOfRoomsResponseDtos;
    }


}
