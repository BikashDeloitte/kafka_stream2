package com.example.kafka_assignment.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FullRecord {
    private Subscriber subscriber;
    private Patient patient;
    private Cases cases;
    private Services service;
}
