package com.xebia.iot.publisher;

import io.moquette.interception.AbstractInterceptHandler;
import io.moquette.interception.InterceptHandler;
import io.moquette.interception.messages.InterceptPublishMessage;
import io.moquette.server.Server;
import io.moquette.server.config.ClasspathResourceLoader;
import io.moquette.server.config.IConfig;
import io.moquette.server.config.IResourceLoader;
import io.moquette.server.config.ResourceLoaderConfig;
import io.netty.buffer.ByteBufUtil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

public class MoquetteMqttServer extends AbstractInterceptHandler {

    private static String msg;

    @Override
    public String getID() {
        return "EmbeddedLauncherPublishListener";
    }


    @Override
    public void onPublish(InterceptPublishMessage message) {
        System.out.println(
                "Received on topic: " + message.getTopicName() + " content: " + new String(ByteBufUtil.getBytes(message.getPayload()), Charset.forName("UTF-8")));
        this.msg = new String(ByteBufUtil.getBytes(message.getPayload()), Charset.forName("UTF-8"));

    }

    public static String getMsg() {
        return msg;
    }

    public static void runTemporaryMqttBroker() {
        IResourceLoader classpathLoader = new ClasspathResourceLoader();
        final IConfig classPathConfig = new ResourceLoaderConfig(classpathLoader);
        final Server mqttBroker = new Server();
        List<? extends InterceptHandler> userHandlers = Collections.singletonList(new MoquetteMqttServer());
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