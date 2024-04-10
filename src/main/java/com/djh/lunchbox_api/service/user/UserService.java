package com.djh.lunchbox_api.service.user;

import com.djh.lunchbox_api.entity.User;
import com.djh.lunchbox_api.repository.UserRepository;
import com.djh.lunchbox_api.service.user.dto.UserCreateRequest;
import com.djh.lunchbox_api.service.user.dto.UserDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * User를 id로 조회한다.
     *
     * @param id
     * @return UserDto
     */
    public UserDto findById(long id) {
        final var user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("유저를 찾을 수 없습니다. id: " + id));
        return UserDto.of(user);
    }

    /**
     * UserCreateRequest를 기반으로 User를 생성합니다.
     *
     * @param req UserCreateRequest
     */
    public void create(UserCreateRequest req) {
        User user = new User();
        user.setEmail(req.getEmail());
        user.setNickname(req.getNickname());
        // TODO:: 암호화 필요
        user.setPassword(req.getPassword());
        user.setProfileImageUrl(req.getProfileImageUrl());
        user.setEnabled(true);
        userRepository.save(user);
    }
}
