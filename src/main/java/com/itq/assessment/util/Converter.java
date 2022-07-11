package com.itq.assessment.util;

import com.itq.assessment.dto.UserDto;
import com.itq.assessment.service.repository.model.User;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static UserDto mapUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName().toLowerCase());
        userDto.setLastName(user.getLastName().toLowerCase());
        userDto.setEmail(user.getEmail().toLowerCase());
        userDto.setPhoneNumber(user.getPhoneNumber());

        return userDto;
    }

    public static User mapUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName().toUpperCase());
        user.setLastName(userDto.getLastName().toUpperCase());
        user.setEmail(userDto.getEmail().toUpperCase());
        user.setPhoneNumber(userDto.getPhoneNumber());

        return user;
    }

    public static List<UserDto> mapUserDtoList(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        users.forEach(user -> {
            userDtoList.add(mapUserDto(user));
        });

        return userDtoList;
    }
}
