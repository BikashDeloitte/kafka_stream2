package com.example.kafka_assignment.binding;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;


//interface for input and output channels
public interface KafkaListenerBinding {

    @Input("input-channel-1")
    KStream<String,String> inputStream();
}
