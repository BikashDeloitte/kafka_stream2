package com.example.kafka_assignment.service;

import com.example.kafka_assignment.entity.Case;
import com.example.kafka_assignment.entity.FullRecord;
import com.example.kafka_assignment.entity.Patient;
import com.example.kafka_assignment.entity.Subscriber;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadingDataService {

    @Autowired
    AuthTopicProducer authTopicProducer;

    public void readFromInputStream() throws IOException {
        File file = new File("src/main/resources/HealthAuth-20220909.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String ch = "";
        int i = -1;
        List<FullRecord> list = new ArrayList<>();

        while ((st = br.readLine()) != null && !ch.equals("TRL")) {
            ch = st.substring(0, 3);

            //store data into java object
            switch (ch) {
                case "SUB":
                    Subscriber subscriber = new Subscriber(
                            ch,
                            st.substring(3, 19).trim(),
                            st.substring(19, 35).trim(),
                            st.substring(35, 51).trim(),
                            st.substring(51, 67).trim(),
                            st.substring(67, 83).trim(),
                            st.substring(83, 99).trim(),
                            st.substring(99, 115).trim(),
                            st.substring(115, 131).trim(),
                            st.substring(131).trim()
                    );

                    //increase index and add new record
                    i++;
                    list.add(new FullRecord());
                    list.get(i).setSubscriber(subscriber);

                    break;

                case "PAT":
                    Patient patient = new Patient(
                            ch,
                            st.substring(3, 19).trim(),
                            st.substring(19, 35).trim(),
                            st.substring(35, 51).trim(),
                            st.substring(51, 67).trim(),
                            st.substring(67, 83).trim(),
                            st.substring(83, 99).trim(),
                            st.substring(99, 115).trim(),
                            st.substring(115, 131).trim(),
                            st.substring(131).trim()
                    );
                    list.get(i).setPatient(patient);
                    break;

                case "CAS":
                    Case cases = new Case(
                            ch,
                            st.substring(3, 19).trim(),
                            st.substring(19, 35).trim(),
                            st.substring(35, 51).trim(),
                            st.substring(51, 67).trim(),
                            st.substring(67, 83).trim(),
                            st.substring(83, 99).trim(),
                            st.substring(99).trim()
                    );
                    list.get(i).setCases(cases);
                    break;

                case "SVC":
                    com.example.kafka_assignment.entity.Service service = new com.example.kafka_assignment.entity.Service(
                            ch,
                            st.substring(3, 19).trim(),
                            st.substring(19, 35).trim(),
                            st.substring(35, 51).trim(),
                            st.substring(51, 67).trim(),
                            st.substring(67, 83).trim(),
                            st.substring(83, 99).trim(),
                            st.substring(99, 115).trim(),
                            st.substring(115).trim()
                    );
                    list.get(i).setService(service);
                    break;
            }
        }

        //converting java object to json
        for (FullRecord ele : list) {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(ele);
            authTopicProducer.publishToTopic(ele.getSubscriber());
            System.out.println(json);
        }
    }
}
