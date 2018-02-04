package com.xebia.iot.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class ConsumerMqttCallBack implements MqttCallback {

    public ConsumerMqttCallBack() {

    }

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        System.out.println("Message received:\n\t"+ new String(mqttMessage.getPayload()) );
        //TO-DO : persiste data according the type of persistence
            //console
            //elasticsearch
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        // not used in this example
    }
}
