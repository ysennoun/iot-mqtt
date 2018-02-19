package com.xebia.iot.main;

import com.xebia.iot.messages.Message;
import com.xebia.iot.publisher.Publisher;

import java.util.Scanner;

public class PublisherMain {

    private static String mqttServerUrl;
    private static String topic;

    public static void main(String[] args) {

        if(args.length != 2)
            throw new IllegalArgumentException("Expected two arguments: <MqttServerUrl> <topic>");
        mqttServerUrl = args[0];
        topic = args[1];

        System.out.println("Start publishing... At any time, you can leave the program by tapping 'exit'.");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String msg = scanner.nextLine();
            if(msg.equals("exit"))
                System.exit(0);
            Message message = new Message(msg);
            Publisher publisher = new Publisher(
                    mqttServerUrl,
                    topic,
                    message.getMqttMessage()
            );
            publisher.send();
        }
    }
}
