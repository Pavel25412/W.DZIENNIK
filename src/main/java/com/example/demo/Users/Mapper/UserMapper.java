package com.example.demo.Users.Mapper;

import com.example.demo.Roles.Entity.RolesEntity;
import com.example.demo.School.Entity.SchoolEntity;
import com.example.demo.Users.DTO.UserRegisterRequest;
import com.example.demo.Users.DTO.UserResponse;
import com.example.demo.Users.Entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "school", source = "school")
    @Mapping(target = "role", source = "role")
    @Mapping(target = "id", ignore = true)
    UserEntity toEntity(UserRegisterRequest request, SchoolEntity school, RolesEntity role);

    @Mapping(target = "schoolName", source = "entity.school.name")
    @Mapping(target = "roleName", source = "entity.role.name")
    UserResponse toResponse(UserEntity entity);
}
