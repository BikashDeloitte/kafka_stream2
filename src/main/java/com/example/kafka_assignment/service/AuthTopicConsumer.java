package com.example.kafka_assignment.service;

import com.example.kafka_assignment.entity.Subscriber;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuthTopicConsumer {
    @KafkaListener(topics="subscriber", groupId="mygroup")
    public void consumeFromTopic(Subscriber fullRecord) {
        System.out.println("Consummed message "+fullRecord);
    }
}
