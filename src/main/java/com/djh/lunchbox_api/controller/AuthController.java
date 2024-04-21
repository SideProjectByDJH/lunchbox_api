package com.djh.lunchbox_api.controller;

import com.djh.lunchbox_api.controller.dto.LoginRequest;
import com.djh.lunchbox_api.service.user.dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping("")
    public UserDto login(@RequestBody LoginRequest request) {
        // 우선 아무 유저 정보나 내려준다.
        System.out.println("request = " + request);
        return UserDto.builder()
                .id(1L)
                .email(request.getEmail())
                .nickname("불타는냉면")
                .profileImageUrl("")
                .enabled(true)
                .build();
    }
}
