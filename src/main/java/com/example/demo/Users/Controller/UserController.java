package com.example.demo.Users.Controller;

 import com.example.demo.Users.DTO.LoginRequest;
import com.example.demo.Users.DTO.UserRegisterRequest;
import com.example.demo.Users.DTO.UserResponse;
import com.example.demo.Users.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService usersService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRegisterRequest request) {
        UserResponse user = usersService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody LoginRequest request) {
        UserResponse user = usersService.loginUser(request);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
