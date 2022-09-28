package com.example.kafka_assignment.service;

import com.example.kafka_assignment.entity.FullRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class AuthTopicProducer {

    public static final String topic = "Auth-Topic";

    @Autowired
    private KafkaTemplate<String, FullRecord> kafkaJson;

    public void publishToTopic(FullRecord fullRecord) {
        this.kafkaJson.send(topic, "KafkaTemplate", fullRecord);
    }

}
