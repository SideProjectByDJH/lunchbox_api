package com.djh.lunchbox_api.service.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateRequest {
    private String nickname;
    private String email;
    private String password;
    private String profileImageUrl;
}
