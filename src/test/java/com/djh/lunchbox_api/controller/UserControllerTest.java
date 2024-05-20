package com.djh.lunchbox_api.controller;

import com.djh.lunchbox_api.service.user.UserService;
import com.djh.lunchbox_api.service.user.dto.UserCreateRequest;
import com.djh.lunchbox_api.service.user.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testFindById() throws Exception {
        var userDto = UserDto.builder()
                .id(1L)
                .email("test@mail.com")
                .nickname("test")
                .profileImageUrl("test")
                .enabled(true)
                .build();
        when(userService.findById(1L)).thenReturn(userDto);

        mvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.email").value("test@mail.com"))
                .andExpect(jsonPath("$.nickname").value("test"))
                .andExpect(jsonPath("$.profileImageUrl").value("test"))
                .andExpect(jsonPath("$.enabled").value(true));
    }

    @Test
    @Disabled
        // TODO:: exception handler 구현 후 테스트 활성화
    void testFindByIdThrowsEntityNotFoundException() throws Exception {
        when(userService.findById(1L)).thenThrow(new EntityNotFoundException("User not found"));

        mvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testSave() throws Exception {
        var request = UserCreateRequest.builder()
                .nickname("test")
                .email("test@mail.com")
                .password("test")
                .profileImageUrl("test")
                .build();
        var json = objectMapper.writeValueAsString(request);

        doNothing().when(userService).create(any(UserCreateRequest.class));

        mvc.perform(post("/api/v1/users")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk());
    }
}
