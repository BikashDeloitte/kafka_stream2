package com.example.kafka_assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient {
    //PAT
    @JsonIgnore
    private String recordType;
    @JsonProperty("CASE_NUMBER")
    private String caseNumber;
    @JsonProperty("PAT_ID")
    private String patientNumber;
    @JsonProperty("PAT_FIRST_NAME")
    private String firstName;
    @JsonProperty("PAT_MIDDLE_NAME")
    private String middleName;
    @JsonProperty("PAT_LAST_NAME")
    private String lastName;
    @JsonProperty("PAT_SEX")
    private String gender;
    @JsonProperty("PAT_DOB")
    private String dateOFBirth; //YYYYMMDD
    @JsonProperty("PAT_PLANE_TYPE")
    private String planType;
    @JsonProperty("PAT_PLAN_NAME")
    private String planName;
}
