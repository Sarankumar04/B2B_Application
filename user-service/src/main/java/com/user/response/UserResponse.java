package com.user.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private double phoneNumber;
    private String email;
}
