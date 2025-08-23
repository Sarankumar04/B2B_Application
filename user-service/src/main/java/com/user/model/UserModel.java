package com.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;
    @Column(name = "user_first_name", nullable = false)
    private String firstName;
    @Column(name = "user_last_name")
    private String lastName;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @CreatedDate
    @Column(name = "created_name")
    private LocalDateTime createdDate;
    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
