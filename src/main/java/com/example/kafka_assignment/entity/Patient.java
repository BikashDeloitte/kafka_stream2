package com.example.kafka_assignment.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient {
    //PAT
    private String recordType;
    private String caseNumber;
    private String patientNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    //YYYYMMDD
    private String dateOFBirth ;
    private String planType;
    private String planName;

}
