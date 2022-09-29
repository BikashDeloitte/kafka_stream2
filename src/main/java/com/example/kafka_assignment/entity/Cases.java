package com.example.kafka_assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cases {
    //CAS
    @JsonIgnore
    private String recordType;
    @JsonProperty("CASE_NUMBER")
    private String caseNumber;
    @JsonProperty("CASE_TYPE")
    private String caseType;
    @JsonProperty("CASE_CODE")
    private String caseCode;
    @JsonProperty("CASE_START_DATE")
    private String caseStartDate;
    @JsonProperty("CASE_END_DATE")
    private String caseEndDate;
    @JsonProperty("CASE_AUTH_TYPE")
    private String authorizationType;
    @JsonProperty("CASE_STATUS")
    private String caseStatus;

}
