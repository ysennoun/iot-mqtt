package com.xebia.iot.mqtt;

import com.xebia.iot.messages.Messages;
import com.xebia.iot.persister.Persister;
import com.xebia.iot.persister.console.ConsolePersister;
import com.xebia.iot.publisher.Publisher;
import com.xebia.iot.subscriber.Subscriber;
import junit.framework.TestCase;

import java.util.ArrayList;

public class PublishSubscribeIntegrationTest extends TestCase {

    public void testPublisher() {
        ConsolePersister consolePersister = new ConsolePersister();
        ArrayList<Persister> arrayPersister = new ArrayList<Persister>();
        arrayPersister.add(consolePersister);
        Subscriber subscriber = new Subscriber("tcp://localhost:1883", "rtopic_test", arrayPersister);
        subscriber.consume();

        Messages message = new Messages("Hello IoT");
        Publisher publisher = new Publisher("tcp://localhost:1883", "topic_test", message.getMqttMessage());


    }
}
