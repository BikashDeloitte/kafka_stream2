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
        readFromInputStream.readFromInputStream();
        return "start Auth-topic";
    }


}
