package com.xebia.iot.messages;

import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.io.UnsupportedEncodingException;

public class Message {

    private static String CHARSET_NAME = "UTF-8";
    private static MqttMessage mqttMessage;
    private static String message;

    public Message(String message) {
        mqttMessage = new MqttMessage();
        this.message = message;
        constructMqttMessage();
    }

    private void constructMqttMessage() {
        mqttMessage.setPayload(message.getBytes());
    }

    public MqttMessage getMqttMessage() { return mqttMessage; }

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
