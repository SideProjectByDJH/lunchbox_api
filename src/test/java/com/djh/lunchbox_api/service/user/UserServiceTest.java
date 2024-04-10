package com.djh.lunchbox_api.service.user;

import com.djh.lunchbox_api.entity.User;
import com.djh.lunchbox_api.repository.UserRepository;
import com.djh.lunchbox_api.service.user.dto.UserCreateRequest;
import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @MockBean
    private UserRepository userRepository = mock(UserRepository.class);

    @Test
    public void testFindById() {
        // given
        User user = new User();
        user.setId(1L);
        user.setEmail("test@mail.com");
        user.setNickname("test");
        user.setPassword("test");
        user.setProfileImageUrl("test");
        user.setEnabled(true);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        UserService userService = new UserService(userRepository);

        // when
        var actual = userService.findById(1L);

        // then
        verify(userRepository, times(1)).findById(1L);
        Assertions.assertThat(actual.getId()).isEqualTo(1L);
        Assertions.assertThat(actual.getEmail()).isEqualTo(user.getEmail());
        Assertions.assertThat(actual.getNickname()).isEqualTo(user.getNickname());
        Assertions.assertThat(actual.getProfileImageUrl()).isEqualTo(user.getProfileImageUrl());
        Assertions.assertThat(actual.isEnabled()).isEqualTo(user.isEnabled());
    }

    @Test
    public void testFindByIdThrowsEntityNotFoundException() {
        // given
        when(userRepository.findById(1L)).thenReturn(Optional.empty());
        UserService userService = new UserService(userRepository);

        // when
        // then
        Assertions.assertThatThrownBy(() -> userService.findById(1L))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessage("유저를 찾을 수 없습니다. id: 1");
    }

    @Test
    public void testCreate() {
        // given
        UserCreateRequest req = new UserCreateRequest();
        req.setEmail("test@mail.com");
        req.setNickname("test");
        req.setPassword("test");
        req.setProfileImageUrl("test");
        UserService userService = new UserService(userRepository);

        // when
        userService.create(req);

        // then
        verify(userRepository, times(1)).save(any(User.class));
    }
}
