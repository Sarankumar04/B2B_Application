package com.order.repository;

import com.order.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    @Query(nativeQuery = true, value = "select * from cart_item where product_id = :productId and user_id = :userId")
    Optional<CartItem> findByUserIdAndProductId(@Param(value = "userId") String userId, @Param(value = "productId") Long productId);

    List<CartItem> findByUserId(String userId);

    Integer deleteCartItemsByUserId(String userId);
}
