package com.digitalhouse.desafioquality;

import com.digitalhouse.desafioquality.entity.District;
import com.digitalhouse.desafioquality.entity.Property;
import com.digitalhouse.desafioquality.entity.Room;
import com.digitalhouse.desafioquality.repository.PropertyRepository;
import com.digitalhouse.desafioquality.repository.impl.PropertyRepositoryImpl;
import com.digitalhouse.desafioquality.rest.dto.PropertyRequestDTO;
import com.digitalhouse.desafioquality.rest.dto.RoomDTO;
import com.digitalhouse.desafioquality.service.ChallengeService;
import com.digitalhouse.desafioquality.service.ChallengeServiceImpl;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DesafioQualityApplicationTests {

    @Test
    void contextLoads() {
    }

    static ChallengeService service;
    static Property property;
    static PropertyRequestDTO propDto;

    @BeforeAll
    static void init(){
        PropertyRepository repository = new PropertyRepositoryImpl();
        service = new ChallengeServiceImpl(repository);
        property = new Property();
        property.setName("Kitnet no Centro");
        property.setDistrict(new District("Centro", 2100.0));
        Room quarto = new Room("Quarto", 5.0, 5.0);
        Room quarto2 = new Room("Quarto maior", 10.0, 10.0);
        List<Room> quartos = new ArrayList<>();
        quartos.add(quarto);
        quartos.add(quarto2);
        property.setRooms(quartos);

        RoomDTO ballroom = new RoomDTO();
        RoomDTO bathroom = new RoomDTO();
        List<RoomDTO> rooms = new ArrayList<>();
        PropertyRequestDTO PropDto = new PropertyRequestDTO();

        ballroom.setRoom_name("Ballroom");
        ballroom.setRoom_width(200.0);
        ballroom.setRoom_length(150.0);

        bathroom.setRoom_name("Bathroom");
        bathroom.setRoom_width(20.0);
        bathroom.setRoom_length(15.8);

        rooms.add(ballroom);
        rooms.add(bathroom);

        PropDto.setProp_name("Casa DTO de Teste");
        PropDto.setRooms(rooms);

        propDto = PropDto;
    }

    @Test
    void shouldReturnPropertiesCorrectSquareMeters(){
        assertEquals(125, service.calculateSquareMeters(property));
    }

    @Test
    void shouldConfirmDistrictExistence(){
        assertNotNull(service.auxDistrictValues(property.getDistrict()));
    }

    @Test
    void shouldReceiveExceptionForNonexistentDistrict(){
        District district = new District("Lixeira", 1800.0);
        assertNull(service.auxDistrictValues(district));
    }

    @Test
    void shouldReturnBiggestRoom(){
        assertEquals("Ballroom", service.calculateBiggestRoom(propDto).getName());
    }

    @Test
    void shouldReturnRoomsCorrectSquareMeters(){
        ArrayList<Double> sizes = new ArrayList<>();
        sizes.add(30000.0);
        sizes.add(316.0);

        assert(sizes.equals(service.calculateAllRoomsSquareMeters(propDto)));
    }

}
