package com.xebia.iot.subscriber;

import com.xebia.iot.persister.Persister;
import org.eclipse.paho.client.mqttv3.*;

import java.util.ArrayList;

public class Subscriber {

    private MqttClient client;
    private String mqttServerUrl;
    private String mqttTopic;
    private ArrayList<Persister> persisters;

    public Subscriber(String mqttServerUrl, String mqttTopic, ArrayList<Persister> persisters){
        this.mqttServerUrl = mqttServerUrl;
        this.mqttTopic = mqttTopic;
        this.persisters = persisters;
    }

    public void consume(){
        try {
            this.client = new MqttClient(this.mqttServerUrl, MqttClient.generateClientId());
            this.client.connect();
            this.client.subscribe(mqttTopic);
            this.client.setCallback( new SubscriberMqttCallBack(this.persisters));
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
