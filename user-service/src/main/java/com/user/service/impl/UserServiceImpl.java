package com.user.service.impl;

import com.user.exception.UserAlreadyExistException;
import com.user.exception.UserNotFoundException;
import com.user.model.User;
import com.user.repository.UserRepository;
import com.user.request.UserRequest;
import com.user.response.UserResponse;
import com.user.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> mapper.map(user, UserResponse.class)).toList();
    }

    @Override
    public UserResponse createUser(UserRequest user) {
        Optional<User> userModel = userRepository.findByUserEmail(user.getEmail());
        if (userModel.isPresent()) {
            throw new UserAlreadyExistException("User Already exist with email :" + user.getEmail());
        }
        User userModel1 = mapper.map(user, User.class);
        userModel1.setUserId(UUID.randomUUID().toString());
        userRepository.save(userModel1);
        return mapper.map(userModel1, UserResponse.class);
    }

    @Override
    public UserResponse fetchUserById(String userId) {
        User userModel = userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        return mapper.map(userModel, UserResponse.class);
    }

    @Override
    public void deleteUserByUserId(String userId) {
        userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        userRepository.deleteById(userId);
    }

    @Override
    public UserResponse updateUser(String userId, UserRequest userRequest) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPassword(userRequest.getPassword());
        user.setModifiedDate(LocalDateTime.now());
        userRepository.save(user);
        return mapper.map(user, UserResponse.class);
    }
}
