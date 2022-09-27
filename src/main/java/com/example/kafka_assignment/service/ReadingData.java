package com.example.kafka_assignment.service;

import com.example.kafka_assignment.entity.Case;
import com.example.kafka_assignment.entity.FullRecord;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadingData {

    private void readFromInputStream() throws IOException {
        File file = new File("src/main/resources/HealthAuth-20220909.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String ch = "";
        List<JSONObject> jsonObjectList = new ArrayList<>();

        while ((st = br.readLine()) != null && !ch.equals("TRL")) {
//            System.out.println(st);

            ch = st.substring(0, 3);

            JSONObject json = new JSONObject();
            switch (ch) {
                case "SUB":
//                    System.out.println("sub = " + st);
                    json.put("CASE_NUMBER", st.substring(3, 19).trim());
                    json.put("MEM_ID", st.substring(19, 35).trim());
                    json.put("MEM_FIRST_NAME", st.substring(35, 51).trim());
                    json.put("MEM_MIDDLE_NAME", st.substring(51, 67).trim());
                    json.put("MEM_LAST_NAME", st.substring(67, 83).trim());
                    json.put("MEM_ADD_1", st.substring(83, 99).trim());
                    json.put("MEM_ADD_2", st.substring(99, 115).trim());
                    json.put("MEM_CITY", st.substring(115, 131).trim());
                    json.put("MEM_PIN", st.substring(131).trim());
//                    System.out.println(json.toString());
                    break;

                case "PAT":
//                    System.out.println("pat = " + st);
                    json.put("CASE_NUMBER", st.substring(3, 19).trim());
                    json.put("PAT_ID", st.substring(19, 35).trim());
                    json.put("PAT_FIRST_NAME", st.substring(35, 51).trim());
                    json.put("PAT_MIDDLE_NAME", st.substring(51, 67).trim());
                    json.put("PAT_LAST_NAME", st.substring(67, 83).trim());
                    json.put("PAT_SEX", st.substring(83, 99).trim());
                    json.put("PAT_DOB", st.substring(99, 115).trim());
                    json.put("PAT_PLANE_TYPE", st.substring(115, 131).trim());
                    json.put("PAT_PLAN_NAME", st.substring(131).trim());
//                    System.out.println(json.toString());
                    break;

                case "CAS":
//                    System.out.println("cas = " + st);
                    json.put("CASE_NUMBER", st.substring(3, 19).trim());
                    json.put("CASE_TYPE", st.substring(19, 35).trim());
                    json.put("CASE_CODE", st.substring(35, 51).trim());
                    json.put("CASE_START_DATE", st.substring(51, 67).trim());
                    json.put("CASE_END_DATE", st.substring(67, 83).trim());
                    json.put("CASE_AUTH_TYPE", st.substring(83, 99).trim());
                    json.put("CASE_STATUS", st.substring(99).trim());
//                    System.out.println(json.toString());
                    break;

                case "SVC":
//                    System.out.println("svc = " + st);
                    json.put("CASE_NUMBER", st.substring(3, 19).trim());
                    json.put("SVC_ID", st.substring(19, 35).trim());
                    json.put("SVC_TYPE", st.substring(35, 51).trim());
                    json.put("SVC_CODE", st.substring(51, 67).trim());
                    json.put("SVC_FAC_ID", st.substring(67, 83).trim());
                    json.put("SVC_FAC_NAME", st.substring(83, 99).trim());
                    json.put("SVC_PHY_ID", st.substring(99, 115).trim());
                    json.put("SVC_PHY_NAME", st.substring(115).trim());
//                    System.out.println(json.toString());
                    break;
            }
            jsonObjectList.add(json);
        }

        JSONObject result = new JSONObject();
        int i = 0;
        while (i < jsonObjectList.size()) {
//            result.put("",jsonObjectList.get(i));
//            result.put("",jsonObjectList.get(i+1));
//            result.put("",jsonObjectList.get(i+2));
//            result.put("",jsonObjectList.get(i+3));.
            ObjectMapper mapper = new ObjectMapper();
            FullRecord record = mapper.convertValue(jsonObjectList.get(i),FullRecord.class);
            System.out.println(record);
            i = i + 4;
        }
    }

    public static void main(String[] args) throws IOException {
        ReadingData ob = new ReadingData();


        ob.readFromInputStream();
    }
}
