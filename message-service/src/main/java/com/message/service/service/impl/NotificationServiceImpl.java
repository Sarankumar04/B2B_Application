package com.message.service.service.impl;

import com.message.service.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @KafkaListener(topics = {"b2b-message"}, groupId = "order-success")
    void sendEmailToCustomer(@Header(value = "par") String msg){
        log.info("This is a test message: {}", msg);
    }

}
