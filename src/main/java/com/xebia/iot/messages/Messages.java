package com.xebia.iot.messages;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;

public class Messages {

    private static String CHARSET_NAME = "UTF-8";
    private MqttMessage mqttMessage;
    private String message;

    public Messages(String message) {

        mqttMessage = new MqttMessage();
        this.message = message;
        constructMqttMessage();
    }

    private void constructMqttMessage() {
        this.mqttMessage.setPayload(this.message.getBytes());
    }

    public MqttMessage getMqttMessage() {
        return this.mqttMessage;
    }

    public String getPaylodFromMqttMessage() {
        try {
            String payload = new String(mqttMessage.getPayload(), CHARSET_NAME);
            return payload;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
