package com.itq.assessment.service;

import com.itq.assessment.dto.UserDto;
import com.itq.assessment.service.impl.UserServiceImpl;
import com.itq.assessment.service.repository.UserRepo;
import com.itq.assessment.test.data.TestData;
import com.itq.assessment.util.Converter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserServiceImpl.class)
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @MockBean
    private UserRepo userRepo;

    @Test
    public void getAllUsers(){
        when(userRepo.findAll()).thenReturn(TestData.getAllUsersModel());

        List<UserDto> users = userService.getAllUsers();
        Assert.assertNotNull(users);
        Assert.assertTrue(users.size() > 1);

    }

    @Test
    public void getOneUser(){
        when(userRepo.findUserById(1L)).thenReturn(Optional.of(TestData.getUserModel("Mokoena", "Tough Guy", "jih.ji@yahoo.com", "0112839872", 1L)));

        UserDto users = userService.getUserById(1L);
        Assert.assertNotNull(users);
        Assert.assertEquals("mokoena", users.getFirstName());

    }

    @Test
    public void addUser(){
        UserDto newUser = new UserDto();
        newUser.setFirstName("Assessment");
        newUser.setLastName("ITQ");
        newUser.setEmail("itq.co.za");
        newUser.setPhoneNumber("0112839872");


        when(userRepo.save(Converter.mapUser(newUser))).thenReturn((TestData.getUserModel("Assessment", "ITQ", "itq.co.za", "0112839872", 1L)));

        UserDto users = userService.addUser(newUser);
        Assert.assertNotNull(users);
        Assert.assertEquals("assessment", users.getFirstName());

    }
}
