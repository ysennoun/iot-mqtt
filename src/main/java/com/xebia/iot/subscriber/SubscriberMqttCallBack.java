package com.xebia.iot.subscriber;

import com.xebia.iot.persister.Persister;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.ArrayList;

public class SubscriberMqttCallBack implements MqttCallback {

    private static ArrayList<Persister> persisters;

    public SubscriberMqttCallBack(ArrayList<Persister> persisters) {
        this.persisters = persisters;
    }

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
    }

    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        for(Persister persister: persisters)
            persister.persiste(new String(mqttMessage.getPayload()));
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) { }
}
