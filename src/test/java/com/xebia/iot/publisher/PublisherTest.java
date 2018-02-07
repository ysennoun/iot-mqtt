package com.xebia.iot.publisher;

import com.xebia.iot.messages.Message;
import junit.framework.TestCase;


public class PublisherTest extends TestCase {

    private static String MSG = "Hello IoT";
    private static String TOPIC = "topic_test";
    private static String URI = "tcp://localhost:1883";

    public void testPublisher(){
        System.out.println("--BEGIN TEST--");
        MoquetteMqttServer.runTemporaryMqttBroker();
        Message message = new Message(MSG);
        Publisher publisher = new Publisher(URI, TOPIC, message.getMqttMessage());
        System.out.println("Publish : " + MSG);
        publisher.send();

        System.out.println("Test on Publisher :  get the same message published");
        assertEquals(MSG, MoquetteMqttServer.getMsg());
        System.out.println("--END--");
    }
}