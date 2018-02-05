package com.xebia.iot.persister;

import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;

import java.io.IOException;

public class PersisterTypeInfoTest  extends TestCase {

    private String persisterTypeInfoJsonES = "{\"type\":\"elasticsearch\",\"brokers\":\"url1:123,url2:321\",\"index\":\"esIndex\"}";
    private String persisterTypeInfoJsonConsole = "{\"type\":\"console\"}";

    private PersisterTypeInfo parsePersisterJson(String json) {
        PersisterTypeInfo result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            result = objectMapper.readValue(json, PersisterTypeInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void testParsePersisterTypeInfoES() {
        assertEquals("elasticsearch", parsePersisterJson(persisterTypeInfoJsonES).getType());
        assertEquals("url1:123,url2:321", parsePersisterJson(persisterTypeInfoJsonES).getBrokers());
        assertNotSame("falseName", parsePersisterJson(persisterTypeInfoJsonES).getIndex());
    }

    public void testParsePersisterTypeInfoConsole() {
        assertEquals("console", parsePersisterJson(persisterTypeInfoJsonConsole).getType());
        assertEquals("", parsePersisterJson(persisterTypeInfoJsonConsole).getBrokers());
        assertEquals("", parsePersisterJson(persisterTypeInfoJsonConsole).getIndex());
    }

}
