package com.example.kafka_assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @ToString
public class Subscriber {
    //SUB
    @JsonProperty(defaultValue = "SUB")
    private String recordType;
    @JsonProperty("CASE_NUMBER")
    private String caseNumber;
    @JsonProperty("MEM_ID")
    private String subcriberNumber;
    @JsonProperty("MEM_FIRST_NAME")
    private String firstName;
    @JsonProperty("MEM_MIDDLE_NAME")
    private String middleName;
    @JsonProperty("MEM_LAST_NAME")
    private String lastName;
    @JsonProperty("MEM_ADD_1")
    private String address1;
    @JsonProperty("MEM_ADD_2")
    private String address2;
    @JsonProperty("MEM_CITY")
    private String city;
    @JsonProperty("MEM_PIN")
    private String zipCode;

}
