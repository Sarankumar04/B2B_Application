package com.user.controller;

import com.user.controller.api.UserApi;
import com.user.request.UserRequest;
import com.user.response.UserResponse;
import com.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponse> createUser(UserRequest user) {
        UserResponse userResponse = userService.createUser(user);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserResponse> getUserById(String userId) {
        UserResponse userResponse = userService.fetchUserById(userId);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteUserByUserId(String userId) {
        userService.deleteUserByUserId(userId);
        return new ResponseEntity<>("User Deleted Successfully",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(String userId, UserRequest userRequest) {
        UserResponse userResponse = userService.updateUser(userId,userRequest);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }
}
