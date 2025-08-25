package com.user.repository;

import com.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    @Query(nativeQuery = true, value = "select * from user where user.email = :email")
    Optional<User> findByUserEmail(@Param(value = "email") String email);

    @Query(value = "select * from user where user.user_id = :userId",nativeQuery = true)
    Optional<User> findByUserId(@Param(value = "userId")String userId);
}
