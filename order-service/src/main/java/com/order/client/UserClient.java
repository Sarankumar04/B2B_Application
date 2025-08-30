package com.order.client;

import com.order.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", path = "/api/v1")
public interface UserClient {

    @GetMapping(path = "/users/{userId}")
    ResponseEntity<UserResponse> getUserById(@PathVariable(name = "userId") String userId);
}
