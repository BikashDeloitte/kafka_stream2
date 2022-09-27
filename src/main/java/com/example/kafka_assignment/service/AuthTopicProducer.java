package com.example.kafka_assignment.service;

import com.example.kafka_assignment.entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class AuthTopicProducer {

    public static final String topic = "subscriber";

    @Autowired
    private KafkaTemplate<String, Subscriber> kafkaJson;

    public void publishToTopic(Subscriber fullRecord) {
        this.kafkaJson.send(topic,"0",fullRecord);
    }

}
