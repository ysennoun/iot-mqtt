package com.xebia.iot.main;

import com.xebia.iot.messages.Messages;
import com.xebia.iot.publisher.Publisher;

public class PublisherMain {

    private static String mqttServerUrl;
    private static String topic;
    private static String msg;

    public static void main(String[] args) {

        if(args.length != 3)
            throw new IllegalArgumentException("Expected three arguments: <MqttServerUrl> <topic> <message> ");
        mqttServerUrl = args[0];
        topic = args[1];
        msg = args[2];

        Messages message = new Messages(msg);
        Publisher publisher = new Publisher(
                mqttServerUrl,
                topic,
                message.getMqttMessage()
        );
        publisher.send();
    }
}
