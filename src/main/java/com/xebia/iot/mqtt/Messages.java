package com.xebia.iot.mqtt;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;

public class Messages {

    MqttMessage mqttMessage;

    public Messages() {
        mqttMessage = new MqttMessage();
    }

    public MqttMessage cronstructMqttMessage(String message) {
        this.mqttMessage.setPayload(message.getBytes());
        return this.mqttMessage;
    }

    public String getPaylodFromMqttMessage() {
        try {
            String payload = new String(mqttMessage.getPayload(), "UTF-8");
            return payload;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
