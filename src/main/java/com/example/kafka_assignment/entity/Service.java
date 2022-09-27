package com.example.kafka_assignment.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Service {
    //SVC
    private String recordType;
    private String caseNumber;
    private String serviceNumber;
    private String serviceType;
    private String sericeCode;
    private String faciityId;
    private String facilityName;
    private String physicianId;
    private String physicianName;

}
