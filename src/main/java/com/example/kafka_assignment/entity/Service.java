package com.example.kafka_assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Service {
    //SVC
    @JsonIgnore
    private String recordType;
    @JsonProperty("CASE_NUMBER")
    private String caseNumber;
    @JsonProperty("SVC_ID")
    private String serviceNumber;
    @JsonProperty("SVC_TYPE")
    private String serviceType;
    @JsonProperty("SVC_CODE")
    private String sericeCode;
    @JsonProperty("SVC_FAC_ID")
    private String faciityId;
    @JsonProperty("SVC_FAC_NAME")
    private String facilityName;
    @JsonProperty("SVC_PHY_ID")
    private String physicianId;
    @JsonProperty("SVC_PHY_NAME")
    private String physicianName;
}
