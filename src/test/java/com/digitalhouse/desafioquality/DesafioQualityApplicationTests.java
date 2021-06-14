package com.digitalhouse.desafioquality;

import com.digitalhouse.desafioquality.entity.District;
import com.digitalhouse.desafioquality.entity.Property;
import com.digitalhouse.desafioquality.entity.Room;
import com.digitalhouse.desafioquality.repository.PropertyRepository;
import com.digitalhouse.desafioquality.repository.impl.PropertyRepositoryImpl;
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
    }

    @Test
    void shouldReturnPropertiesCorrectSquareMeters(){
        assertEquals(125, service.calculateSquareMeters(property));
    }

    @Test
    void shouldConfirmDistrictExistence(){

    }

    @Test
    void shouldReceiveExceptionForNonexistentDistrict(){

    }

    @Test
    void shouldReturnBiggestRoom(){

    }

    @Test
    void shouldReturnRoomsCorrectSquareMeters(){

    }

}
