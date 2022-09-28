package com.example.kafka_assignment.service;

import com.example.kafka_assignment.entity.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//subscriber
@Service
public class SubscriberProducer {
    public static final String topic = "subscriber";

    @Autowired
    private KafkaTemplate<String, Subscriber> kafkaJson;

    public void publishToTopic(Subscriber subscriber) {
        this.kafkaJson.send(topic,"0",subscriber);
    }

}