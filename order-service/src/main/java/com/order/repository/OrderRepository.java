package com.order.repository;

import com.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByUserIdAndOrderId(String userId, Long orderId);

//    @Query(name ="select * from orders where orders.user_id = :userId" ,nativeQuery = true)
    List<Order> findByUserId(String userId);
}
