package com.example.kafka_assignment.service;

import com.example.kafka_assignment.entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadingData2 {

    private void readFromInputStream() throws IOException {
        File file = new File("src/main/resources/HealthAuth-20220909.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String ch = "";
        int i = -1;
        List<FullRecord> list = new ArrayList<>();

        while ((st = br.readLine()) != null && !ch.equals("TRL")) {
//            System.out.println(st);

            ch = st.substring(0, 3);

            switch (ch) {
                case "SUB":
//                    System.out.println("sub = " + st);
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

//                    System.out.println(json.toString());
                    break;

                case "PAT":
//                    System.out.println("pat = " + st);
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
//                    System.out.println(json.toString());
                    break;

                case "CAS":
//                    System.out.println("cas = " + st);
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
//                    System.out.println(json.toString());
                    break;

                case "SVC":
//                    System.out.println("svc = " + st);
                    Service service = new Service(
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


//                    System.out.println(json.toString());
                    break;
            }
            System.out.println(list);
        }

        for (FullRecord ele : list) {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(ele);
            System.out.println(json);
        }
    }

    public static void main(String[] args) throws IOException {
        ReadingData2 ob = new ReadingData2();


        ob.readFromInputStream();
    }
}
