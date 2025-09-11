package com.user.controller.api;

import com.user.request.UserRequest;
import com.user.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "User")
public interface UserApi {

    @Operation(summary = "Get Users", description = "Get Users Returns All the users from the table")
    @ApiResponse(responseCode = "200", description = "Successfully Fetched all users", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserResponse.class)))
    @ApiResponse(responseCode = "403", description = "Not Authorized to use")
    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<UserResponse>> getAllUsers();

    @Operation(summary = "Create User", description = "Used to create an user")
    @ApiResponse(responseCode = "201", description = "Successfully created the user", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserResponse.class)))
    @ApiResponse(responseCode = "403", description = "Not Authorized to user")
    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponse> createUser(
            @Parameter(in = ParameterIn.DEFAULT, description = "Body of the user") @RequestBody @Valid UserRequest user
    );

    @Operation(summary = "Update User", description = "Update and returns the existing user")
    @ApiResponse(responseCode = "200", description = "Successfully fetched the user", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserResponse.class)))
    @ApiResponse(responseCode = "403", description = "Not Authorized to user")
    @ApiResponse(responseCode = "404", description = "User Not Found")
    @GetMapping(path = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponse> getUserById(
            @Parameter(in = ParameterIn.PATH, description = "Id of the user", required = true) @NotEmpty @PathVariable(name = "userId") String userId
    );

    @Operation(summary = "Delete User", description = "Delete User")
    @ApiResponse(responseCode = "200", description = "Successfully Updated the user data")
    @ApiResponse(responseCode = "403", description = "Not Authorized to user")
    @ApiResponse(responseCode = "404", description = "User Not Found")
    @DeleteMapping(path = "/users/{userId}")
    ResponseEntity<String> deleteUserByUserId(
            @Parameter(in = ParameterIn.PATH, description = "Id of the user", required = true) @NotEmpty @PathVariable(name = "userId") String userId
    );

    @Operation(summary = "Update User", description = "Update user")
    @ApiResponse(responseCode = "200", description = "Successfully Updated the user data", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = UserResponse.class)))
    @ApiResponse(responseCode = "403", description = "Not Authorized to user")
    @ApiResponse(responseCode = "404", description = "User Not Found")
    @PutMapping(path = "/users/{userId}")
    ResponseEntity<UserResponse> updateUser(
            @Parameter(in = ParameterIn.PATH, description = "Id of the user", required = true) @NotEmpty @PathVariable(name = "userId") String userId,
            @Parameter(in = ParameterIn.DEFAULT, description = "Body Of the User") @Valid @RequestBody UserRequest userRequest
    );
}
