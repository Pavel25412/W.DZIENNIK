package com.example.demo.Users.DTO;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String roleName;
    private String schoolName;
}
