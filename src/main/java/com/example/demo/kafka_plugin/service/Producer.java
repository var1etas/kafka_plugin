package com.example.demo.kafka_plugin.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;

public class Producer {
    public void SendMessage(ProducerRecord<String,String> record) {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        // See https://kafka.apache.org/documentation/#producerconfigs for more properties

        var v = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(null);
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        Thread.currentThread().setContextClassLoader(v);
        producer.send(record);
    }
}
