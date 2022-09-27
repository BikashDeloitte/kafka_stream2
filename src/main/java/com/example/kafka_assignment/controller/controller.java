package com.example.kafka_assignment.controller;

import com.example.kafka_assignment.entity.Subscriber;
import com.example.kafka_assignment.service.AuthTopicProducer;
import com.example.kafka_assignment.service.ReadingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class controller {
    @Autowired
    AuthTopicProducer authTopicProducer;
    @Autowired
    ReadingDataService readFromInputStream;

//    @GetMapping("/start/authTopic")
//    public String startAuthTopic(@RequestBody User user){
//        authTopicProducer.publishToTopic(user);
//        return "start Auth-topic";
//    }
//
//    @GetMapping("/start/authTopic2")
//    public String startAuthTopic2(){
//        User user = new User("Ram",32);
//        authTopicProducer.publishToTopic(user);
//        return "start Auth-topic";
//    }

    @GetMapping("/start/authTopic3")
    public String startAuthTopic3() throws IOException {
        readFromInputStream.readFromInputStream();
        return "start Auth-topic";
    }

//    @GetMapping("/start/authTopic4")
//    public String startAuthTopic4(@RequestBody Subscriber subscriber) throws IOException {
//        authTopicProducer.publishToTopic(subscriber);
//        return "start Auth-topic";
//    }
}
