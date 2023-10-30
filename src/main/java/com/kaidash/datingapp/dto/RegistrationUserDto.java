package com.kaidash.datingapp.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RegistrationUserDto {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private Date birthdate;
    private String gender;
    private String orientation;
    private String bio;
}
