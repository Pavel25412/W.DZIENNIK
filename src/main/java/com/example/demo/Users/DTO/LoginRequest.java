package com.example.demo.Users.DTO;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
