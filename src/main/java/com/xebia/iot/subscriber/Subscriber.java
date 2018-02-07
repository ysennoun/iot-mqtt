package com.xebia.iot.subscriber;

import com.xebia.iot.persister.Persister;
import org.eclipse.paho.client.mqttv3.*;

import java.util.ArrayList;

public class Subscriber {

    private static MqttClient client;
    private static String mqttServerUrl;
    private static String mqttTopic;
    private static ArrayList<Persister> persisters;

    public Subscriber(String mqttServerUrl, String mqttTopic, ArrayList<Persister> persisters){
        this.mqttServerUrl = mqttServerUrl;
        this.mqttTopic = mqttTopic;
        this.persisters = persisters;
    }

    public void consume(){
        try {
            client = new MqttClient(mqttServerUrl, MqttClient.generateClientId());
            client.connect();
            client.subscribe(mqttTopic);
            client.setCallback( new SubscriberMqttCallBack(persisters));
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
