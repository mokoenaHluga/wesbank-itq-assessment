package com.itq.assessment.service.impl;

import com.itq.assessment.dto.UserDto;
import com.itq.assessment.exception.NoUserFoundException;
import com.itq.assessment.service.UserService;
import com.itq.assessment.service.repository.UserRepo;
import com.itq.assessment.service.repository.model.User;
import com.itq.assessment.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final String noUserMessage = "No user found for the provided id";

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return Converter.mapUserDtoList(userRepo.findAll());
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepo.findUserById(id)
                .orElseThrow(() -> new NoUserFoundException(noUserMessage));

        return Converter.mapUserDto(user);
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = userRepo.save(Converter.mapUser(userDto));
        return Converter.mapUserDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = userRepo.save(Converter.mapUser(userDto));
        return Converter.mapUserDto(user);
    }
}
