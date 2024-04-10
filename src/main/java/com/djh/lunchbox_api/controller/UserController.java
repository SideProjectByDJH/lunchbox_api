package com.djh.lunchbox_api.controller;


import com.djh.lunchbox_api.service.user.UserService;
import com.djh.lunchbox_api.service.user.dto.UserCreateRequest;
import com.djh.lunchbox_api.service.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping("")
    public void save(@RequestBody UserCreateRequest request) {
        // TODO:: 반환 값이 정해지면 수정
        userService.create(request);
    }
}
