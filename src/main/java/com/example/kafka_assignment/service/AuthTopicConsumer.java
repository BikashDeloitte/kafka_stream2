package com.example.kafka_assignment.service;

import com.example.kafka_assignment.entity.FullRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuthTopicConsumer {
    @KafkaListener(topics="Auth-Topic", groupId="mygroup")
    public void consumeFromTopic(FullRecord fullRecord) {
        System.out.println("Consummed message "+fullRecord);
    }
}
