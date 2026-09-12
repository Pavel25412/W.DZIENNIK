package com.example.demo.Users.Service;

import com.example.demo.Roles.Entity.RolesEntity;
import com.example.demo.Roles.Repository.RolesRepository;
import com.example.demo.School.Entity.SchoolEntity;
import com.example.demo.School.Repository.SchoolRepository;
import com.example.demo.Users.DTO.LoginRequest;
import com.example.demo.Users.DTO.UserRegisterRequest;
import com.example.demo.Users.DTO.UserResponse;
import com.example.demo.Users.Entity.UserEntity;
import com.example.demo.Users.Mapper.UserMapper;
import com.example.demo.Users.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository usersRepository;
    private final SchoolRepository schoolRepository;
    private final RolesRepository rolesRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponse registerUser(UserRegisterRequest request) {
        if (usersRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Użytkownik z podanym email już istnieje");
        }

        SchoolEntity school = schoolRepository.findById(request.getSchoolId())
                .orElseThrow(() -> new RuntimeException("Szkoła nie znaleziona"));

        RolesEntity role = rolesRepository.findById(request.getRoleId())
                .orElseThrow(() -> new RuntimeException("Роль не найдена"));

        UserEntity entity = userMapper.toEntity(request, school, role);
        UserEntity savedEntity = usersRepository.save(entity);

        return userMapper.toResponse(savedEntity);
    }

    public UserResponse loginUser(LoginRequest request) {
        UserEntity user = usersRepository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("Nieprawidłowy login lub hasło"));

        if(passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Nieprawidłowy login lub hasło");
        }

        return userMapper.toResponse(user);
    }
}
