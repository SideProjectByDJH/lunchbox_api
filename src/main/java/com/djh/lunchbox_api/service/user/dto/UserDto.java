package com.djh.lunchbox_api.service.user.dto;

import com.djh.lunchbox_api.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {

    private Long id;

    private String email;

    private String nickname;

    private String profileImageUrl;

    private boolean enabled;

    public static UserDto of(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setNickname(user.getNickname());
        userDto.setProfileImageUrl(user.getProfileImageUrl());
        userDto.setEnabled(user.isEnabled());
        return userDto;
    }
}
