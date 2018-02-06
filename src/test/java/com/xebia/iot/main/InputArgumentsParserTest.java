package com.xebia.iot.main;

import junit.framework.TestCase;

public class InputArgumentsParserTest extends TestCase {

    private static String sentence = "Here is the content of the file :\n" +
            "Paris\n" +
            "Istanbul\n" +
            "Sevilla\n" +
            "Cairo";

    public void testFileContent() {
        String filePath = getClass().getClassLoader().getResource("fileTest.txt").getFile();
        String content = InputArgumentsParser.getContentConfigurationFilePath(filePath);
        assertNotSame(null, content);
        assertEquals(sentence, content);
    }
}
