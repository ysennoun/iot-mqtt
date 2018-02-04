package com.xebia.iot.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Publisher {

    MqttClient client;
    String mqttServerUrl;
    String mqttTopic;
    MqttMessage mqttMessage;

    public Publisher(String mqttServerUrl, String mqttTopic, MqttMessage mqttMessage) {
        this.mqttServerUrl = mqttServerUrl;
        this.mqttTopic = mqttTopic;
        this.mqttMessage = mqttMessage;
    }

    public void connectMqttServer() throws MqttException {
            client = new MqttClient(mqttServerUrl, MqttClient.generateClientId());
    }

    public void send() throws MqttException {
        client.connect();
        client.publish(mqttTopic, mqttMessage);
        client.disconnect();
    }
}
