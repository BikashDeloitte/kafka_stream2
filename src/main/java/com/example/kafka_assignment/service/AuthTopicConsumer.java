package com.example.kafka_assignment.service;

import com.example.kafka_assignment.entity.FullRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuthTopicConsumer {
    @Autowired
    ReadingDataService readingDataService;

    @KafkaListener(topics="Auth-Topic", groupId="mygroup")
    public void consumeFromTopic(FullRecord fullRecord) {

        //sending data for splitting it
        readingDataService.splitData(fullRecord);
        System.out.println("Consummed message from Auth-Topic = "+fullRecord);
    }
}
