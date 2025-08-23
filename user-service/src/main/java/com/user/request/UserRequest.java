package com.user.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    @NotEmpty
    private String firstName;
    private String lastName;
    @NotNull
    private Long phoneNumber;
    @Email
    private String email;
    @NotNull
    @NotEmpty
    private String password;
}
