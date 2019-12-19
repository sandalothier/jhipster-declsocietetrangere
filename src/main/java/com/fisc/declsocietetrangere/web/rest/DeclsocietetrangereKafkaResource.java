package com.fisc.declsocietetrangere.web.rest;

import com.fisc.declsocietetrangere.service.DeclsocietetrangereKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/declsocietetrangere-kafka")
public class DeclsocietetrangereKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DeclsocietetrangereKafkaResource.class);

    private DeclsocietetrangereKafkaProducer kafkaProducer;

    public DeclsocietetrangereKafkaResource(DeclsocietetrangereKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
