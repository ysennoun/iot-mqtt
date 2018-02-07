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
        System.out.println("--BEGIN TEST--");
        System.out.println("Test on Message: be same.");
        assertEquals(msg, getMessage(msg));
        System.out.println("--END--");
    }

    public void testWrongMessage()
    {
        System.out.println("--BEGIN TEST--");
        System.out.println("Test on Message: not be same.");
        assertNotSame(wrongMsg, getMessage(msg));
        System.out.println("--END--");
    }
}
