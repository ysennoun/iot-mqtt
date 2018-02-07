package com.xebia.iot.publisher;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Publisher {

    private MqttClient client;
    private String mqttServerUrl;
    private String mqttTopic;
    private MqttMessage mqttMessage;

    public Publisher(String mqttServerUrl, String mqttTopic, MqttMessage mqttMessage) {
        this.mqttServerUrl = mqttServerUrl;
        this.mqttTopic = mqttTopic;
        this.mqttMessage = mqttMessage;
    }

    public void send(){
        try {
            client = new MqttClient(mqttServerUrl, MqttClient.generateClientId());
            client.connect();
            client.publish(mqttTopic, mqttMessage);
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
