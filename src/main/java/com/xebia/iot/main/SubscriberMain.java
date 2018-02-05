package com.xebia.iot.main;

import com.xebia.iot.persister.Persister;
import com.xebia.iot.subscriber.Subscriber;

import java.util.ArrayList;


public class SubscriberMain {

    private static String mqttServerUrl;
    private static String topic;
    private static String configurationFilePath;

    public static void main(String[] args) {

        if(args.length != 3)
            throw new IllegalArgumentException("Expected one argument:three arguments: <MqttServerUrl> <topic> <Persistance_configuration_file_path>");

        mqttServerUrl = args[0];
        topic = args[1];
        configurationFilePath = args[2];

        InputArgumentsParser inputArgsParser = new InputArgumentsParser(configurationFilePath);

        Subscriber subscriber = new Subscriber(
                mqttServerUrl,
                topic,
                inputArgsParser.getPersisters()
        );
        subscriber.consume();
    }
}

