package com.example.kafka_assignment.service;

import com.example.kafka_assignment.binding.KafkaListenerBinding;
import com.example.kafka_assignment.entity.*;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;


//subscriber
@Service
@EnableBinding(KafkaListenerBinding.class)
public class KStreamProducer {
    public static final String subscriber = "subscriber";
    public static final String patient = "patient";
    public static final String cases = "cases";
    public static final String services = "services";


    //json serde
    public class SubscriberSerde extends Serdes.WrapperSerde<Subscriber> {
        public SubscriberSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>(Subscriber.class));
        }
    }

    public class PatientSerde extends Serdes.WrapperSerde<Patient> {
        public PatientSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>(Patient.class));
        }
    }

    public class CaseSerde extends Serdes.WrapperSerde<Cases> {
        public CaseSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>(Cases.class));
        }
    }

    public class ServicesSerde extends Serdes.WrapperSerde<Services> {
        public ServicesSerde() {
            super(new JsonSerializer<>(), new JsonDeserializer<>(Services.class));
        }
    }

    @StreamListener("input-channel-1")
    public void publishToTopic(KStream<String, FullRecord> fullRecordKStream) {

        KStream<String, Subscriber> subscriberKStream = fullRecordKStream.map((k, v) -> new KeyValue<>("KStream", v.getSubscriber()));
        KStream<String, Patient> patientKStream = fullRecordKStream.map((k, v) -> new KeyValue<>("KStream", v.getPatient()));
        KStream<String, Cases> caseKStream = fullRecordKStream.map((k, v) -> new KeyValue<>("KStream", v.getCases()));
        KStream<String, Services> servicesKStream = fullRecordKStream.map((k, v) -> new KeyValue<>("KStream", v.getService()));

        //adding Produced.with() as it don't have Serde after conversion
        subscriberKStream.to(subscriber, Produced.with(Serdes.String(), new SubscriberSerde()));
        System.out.println("send message to subscriber topic through KStream");
        patientKStream.to(patient, Produced.with(Serdes.String(), new PatientSerde()));
        System.out.println("send message to patient topic through KStream");
        caseKStream.to(cases, Produced.with(Serdes.String(), new CaseSerde()));
        System.out.println("send message to case topic through KStream");
        servicesKStream.to(services, Produced.with(Serdes.String(), new ServicesSerde()));
        System.out.println("send message to service topic through KStream");

    }


}