# IoT-MQTT

This project enables to create a publisher and a subscriber for MQTT server.

## Get Jar

Execute the following command:

	mvn clean package

It will give you a jar name `iot-mqtt-1.0-SNAPSHOT-jar-with-dependencies.jar`.

## MQTT Publisher

To create a publisher, execute the following command:

	java -cp iot-mqtt-1.0-SNAPSHOT-jar-with-dependencies.jar com.xebia.iot.main.PublisherMain <serverUri> <topic>

where `<serverUri>` is alike: `"tcp://<mqtt-broker-ip>:1883"`

## MQTT Subscriber

To create a subscriber, execute the following command:

	java -cp iot-mqtt-1.0-SNAPSHOT-jar-with-dependencies.jar com.xebia.iot.main.PublisherMain <serverUri> <topic>
