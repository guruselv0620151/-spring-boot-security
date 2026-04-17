package com.example.security.controller;

import com.suyo.springauth.models.AuthResponse;
import com.suyo.springauth.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertEquals;import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.suyo.springauth.service.AuthService;
@SpringBootTest(classes=com.suyo.springauth.service.AuthService.class)
class AuthControllerTest {



    @MockBean
    private AuthService authService;



    @Test
    void testLoginSuccess() throws Exception {
       Mockito.when(authService.login(Mockito.any())).
                thenReturn(new AuthResponse("test"));

        com.suyo.springauth.models.AuthResponse  token = authService.login(Mockito.any());
        assertEquals("test",token.getToken());
    }
}