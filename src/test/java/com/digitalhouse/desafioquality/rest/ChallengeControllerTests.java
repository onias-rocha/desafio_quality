package com.digitalhouse.desafioquality.rest;

import com.digitalhouse.desafioquality.service.ChallengeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ChallengeController.class)
public class ChallengeControllerTests {

    @Autowired
    MockMvc mock;

    @MockBean
    ChallengeService service;

    @Test
    public void welcomeMessage() throws Exception {
        mock.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType((MediaType.valueOf("text/plain;charset=UTF-8"))))
                .andExpect(content().string("Welcome to the properties API"));
    }


}
