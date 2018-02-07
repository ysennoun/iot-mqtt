package com.xebia.iot.messages;

import junit.framework.TestCase;

public class MessageTest extends TestCase {

    private String msg = "My mqtt message is that ^^!";
    private String wrongMsg = "My mqtt message is not the same ^^!";

    private String getMessage(String msg) {
        Message messagesClass = new Message(msg);
        return messagesClass.getPaylodFromMqttMessage();
    }

    public void testRightMessage()
    {
        assertEquals(msg, getMessage(msg));
    }

    public void testWrongMessage()
    {
        assertNotSame(wrongMsg, getMessage(msg));
    }
}
