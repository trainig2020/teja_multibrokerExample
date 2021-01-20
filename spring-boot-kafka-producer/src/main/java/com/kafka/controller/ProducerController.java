package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    static final String TOPIC = "ProdConsTopic";

    @GetMapping("publish/{message}")
    public String publishMessage(@PathVariable("message") String message) {
        kafkaTemplate.send(TOPIC, message);
        return "Message Published on Kafka: "+message;
    }

}
