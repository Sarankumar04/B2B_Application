package com.order.config;

import com.order.model.Order;
import com.order.model.OrderItem;
import com.order.response.CartItemResponse;
import com.order.response.OrderResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfiguration {

    @Bean
    ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.typeMap(CartItemResponse.class, OrderItem.class)
                .addMapping(CartItemResponse::getProductId, OrderItem::setProductId)
                .addMapping(CartItemResponse::getUserId, OrderItem::setUserId);
        return mapper;
    }
}

