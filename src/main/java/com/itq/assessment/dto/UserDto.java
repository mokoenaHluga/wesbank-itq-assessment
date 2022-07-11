package com.itq.assessment.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
