package com.example.kafka_assignment.controller;

import com.example.kafka_assignment.service.AuthTopicProducer;
import com.example.kafka_assignment.service.ReadingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class controller {

    @Autowired
    ReadingDataService readFromInputStream;

    @GetMapping("/start/authTopic3")
    public String startAuthTopic3() throws IOException {
        readFromInputStream.readFromInputStream("src/main/resources/HealthAuth-20220909.txt");
        readFromInputStream.readFromInputStream("src/main/resources/HealthAuth-20220912.txt");
        readFromInputStream.readFromInputStream("src/main/resources/HealthAuth-20220915.txt");
        return "start Auth-topic";
    }


}
