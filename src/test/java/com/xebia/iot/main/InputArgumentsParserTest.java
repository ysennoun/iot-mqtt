package com.xebia.iot.main;

import junit.framework.TestCase;

public class InputArgumentsParserTest extends TestCase {

    private static String sentence = "Here is the content of the file :\n" +
            "Paris\n" +
            "Istanbul\n" +
            "Sevilla\n" +
            "Cairo";

    public void testFileContent() {
        System.out.println("--BEGIN TEST--");
        System.out.println("Test on InputArgumentsParser: be able to open file and retrieve content.");
        String filePath = getClass().getClassLoader().getResource("fileTest.txt").getFile();
        String content = InputArgumentsParser.getContentConfigurationFilePath(filePath);
        System.out.println("test 1: content should not be null");
        assertNotSame(null, content);
        System.out.println("test 2: content should be equals to " + sentence);
        assertEquals(sentence, content);
        System.out.println("--END--");
    }
}
