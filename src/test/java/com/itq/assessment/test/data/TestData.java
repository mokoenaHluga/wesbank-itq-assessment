package com.itq.assessment.test.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itq.assessment.dto.SumRequestDto;
import com.itq.assessment.dto.UserDto;
import com.itq.assessment.service.repository.model.User;

import java.util.ArrayList;
import java.util.List;


public class TestData {
    public static String palindromeTestData = "the last year until 2112 that can be written the same way backward or forward.";

    public static UserDto getUser(String firstName, String lastName, String email, String phoneNumber,
                                  Long id) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setId(id);
        userDto.setEmail(email);
        userDto.setPhoneNumber(phoneNumber);

        return userDto;
    }

    public static List<UserDto> getAllUsers(){
        List<UserDto> users = new ArrayList<>();
        users.add(getUser("Mokoena", "Tough Guy", "jih.ji@yahoo.com", "0112839872", 1L));
        users.add(getUser("Sarah", "Tough Girl", "ji@gmail.com", "0112839872", 2L));

        return users;
    }

    public static SumRequestDto getSumRequest(int target, int [] array){
        SumRequestDto sumRequestDto = new SumRequestDto();
        sumRequestDto.setTarget(target);
        sumRequestDto.setArray(array);

        return sumRequestDto;

    }

    public static List<User> getAllUsersModel() {
        List<User> users = new ArrayList<>();
        users.add(getUserModel("Mokoena", "Tough Guy", "jih.ji@yahoo.com", "0112839872", 1L));
        users.add(getUserModel("Sarah", "Tough Girl", "ji@gmail.com", "0112839872", 2L));

        return users;
    }

    public static User getUserModel(String firstName, String lastName, String email, String phoneNumber,
                                  Long id) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setId(id);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);

        return user;
    }
}
