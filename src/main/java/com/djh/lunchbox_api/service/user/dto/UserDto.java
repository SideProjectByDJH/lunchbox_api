package com.djh.lunchbox_api.service.user.dto;

import com.djh.lunchbox_api.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {

    private Long id;

    private String email;

    private String nickname;

    private String profileImageUrl;

    private boolean enabled;

    public static UserDto of(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .profileImageUrl(user.getProfileImageUrl())
                .enabled(user.isEnabled())
                .build();
    }
}
