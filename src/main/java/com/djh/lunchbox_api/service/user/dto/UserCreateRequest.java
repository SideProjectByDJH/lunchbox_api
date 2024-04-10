package com.djh.lunchbox_api.service.user.dto;

import lombok.Getter;

@Getter
public class UserCreateRequest {
    private String nickname;
    private String email;
    private String password;
    private String profileImageUrl;
}
