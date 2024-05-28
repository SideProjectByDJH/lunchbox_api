package com.djh.lunchbox_api.service.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserCreateRequest {
    private String nickname;
    private String email;
    private String password;
    private String profileImageUrl;
}
