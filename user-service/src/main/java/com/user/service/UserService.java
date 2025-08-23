package com.user.service;

import com.user.request.UserRequest;
import com.user.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse createUser(UserRequest user);

    UserResponse fetchUserById(String userId);

    void deleteUserByUserId(String userId);

    UserResponse updateUser(String userId, UserRequest userRequest);
}
