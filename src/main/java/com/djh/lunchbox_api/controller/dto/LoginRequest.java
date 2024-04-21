package com.djh.lunchbox_api.controller.dto;

import lombok.Data;

@Data
public class LoginRequest {
    String email;
    String password;
}
