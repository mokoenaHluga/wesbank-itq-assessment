package com.itq.assessment.service;

import com.itq.assessment.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    UserDto addUser(UserDto userDto);

    void deleteUser(Long id);

    UserDto updateUser(UserDto userDto);
}
