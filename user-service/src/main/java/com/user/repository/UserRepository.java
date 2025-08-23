package com.user.repository;

import com.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, String> {

    @Query(nativeQuery = true, value = "select * from user where user.email = :email")
    Optional<UserModel> findByUserEmail(@Param(value = "email") String email);

    @Query(value = "select * from user where user.user_id = :userId",nativeQuery = true)
    Optional<UserModel> findByUserId(@Param(value = "userId")String userId);
}
