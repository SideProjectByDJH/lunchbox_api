package com.djh.lunchbox_api.repository;

import com.djh.lunchbox_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
