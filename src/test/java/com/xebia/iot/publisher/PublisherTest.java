package com.xebia.iot.publisher;

import com.xebia.iot.messages.Message;
import com.xebia.iot.moquette.MoquetteMqttServer;
import junit.framework.TestCase;


public class PublisherTest extends TestCase {

    private static String MSG = "Hello IoT";
    private static String TOPIC = "topic_test";
    private static String URI = "tcp://localhost:1883";

    public void testPublisher(){
        MoquetteMqttServer.runTemporaryMqttBroker();
        Message message = new Message(MSG);
        Publisher publisher = new Publisher(URI, TOPIC, message.getMqttMessage());
        System.out.println("Publish : " + MSG);
        publisher.send();
        assertEquals(MSG, MoquetteMqttServer.getMsg());
    }
}