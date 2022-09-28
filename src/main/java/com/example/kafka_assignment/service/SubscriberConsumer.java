package com.example.kafka_assignment.service;

import com.example.kafka_assignment.entity.Subscriber;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SubscriberConsumer {

    @KafkaListener(topics = "subscriber", groupId = "subscriberGroup")
    public void consumeFromTopic(Subscriber subscriber) {
        System.out.println("Consummed message from subscriber = " + subscriber);
    }
}