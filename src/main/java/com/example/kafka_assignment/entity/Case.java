package com.example.kafka_assignment.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Case {
    //CAS
    private String recordType;
    private String caseNumber;
    private String caseType;
    private String caseCode;
    private String caseStartDate;
    private String caseEndDate;
    private String authorizationType;
    private String caseStatus;

}
