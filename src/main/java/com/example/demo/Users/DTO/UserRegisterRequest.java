package com.example.demo.Users.DTO;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long schoolId;
    private Long roleId;
}
