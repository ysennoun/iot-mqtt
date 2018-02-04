package com.xebia.iot.mqtt;

import org.eclipse.paho.client.mqttv3.*;

public class Consumer {

    MqttClient client;
    String mqttServerUrl;
    String mqttTopic;

    public Consumer(String mqttServerUrl, String mqttTopic) throws MqttException {
        this.mqttServerUrl = mqttServerUrl;
        this.mqttTopic = mqttTopic;
        client = new MqttClient(mqttServerUrl, MqttClient.generateClientId());
    }

    public void consume() throws MqttException {
        client.subscribe(mqttTopic);
        client.setCallback( new ConsumerMqttCallBack());
        client.connect();
    }

}
