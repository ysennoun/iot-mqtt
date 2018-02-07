package com.xebia.iot.moquette;

import io.moquette.interception.AbstractInterceptHandler;
import io.moquette.interception.InterceptHandler;
import io.moquette.interception.messages.InterceptPublishMessage;
import io.moquette.server.Server;
import io.moquette.server.config.ClasspathConfig;
import io.moquette.server.config.IConfig;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MoquetteMqttServer extends AbstractInterceptHandler {

    private static String msg;

    @Override
    public void onPublish(InterceptPublishMessage message) {
        System.out.println("Moquette mqtt broker message intercepted, topic: " + message.getTopicName()
                + ", content: " + new String(message.getPayload().array()));
        this.msg = new String(message.getPayload().array());
    }

    public static String getMsg() {
        return msg;
    }

    public static void runTemporaryMqttBroker() {
        final IConfig classPathConfig = new ClasspathConfig();
        final Server mqttBroker = new Server();
        final List<? extends InterceptHandler> userHandlers = Arrays.asList(new MoquetteMqttServer());
        try {
            mqttBroker.startServer(classPathConfig, userHandlers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Moquette mqtt broker started during 3s, press ctrl-c to shutdown..");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mqttBroker.stopServer();
                System.out.println("Moquette mqtt broker stopped");
            }
        });
    }
}