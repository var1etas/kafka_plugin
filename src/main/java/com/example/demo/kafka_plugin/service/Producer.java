package com.example.demo.kafka_plugin.service;

import com.example.demo.kafka_plugin.service.settings.PortSettings;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class Producer {
    static PortSettings.State state =
            Objects.requireNonNull(PortSettings.getInstance().getState());
    static String port = state.port;
    public void SendMessage(ProducerRecord<String,String> record) {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, port);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        var v = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(null);
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        Thread.currentThread().setContextClassLoader(v);

        Runnable send = () -> {
            try {
                RecordMetadata metadata = producer.send(record).get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        };
        Thread tr = new Thread(send);
        tr.start();
    }
}
