package com.xebia.iot.persister;

import junit.framework.TestCase;

public class PersistersTypeInfoTest extends TestCase {

    private String json = "{\"persisters\":[{\"type\":\"elasticsearch\",\"brokers\":\"url1:123,url2:321\",\"index\":\"esIndex\"},{\"type\":\"console\",\"brokers\":\"\",\"index\":\"\"}]}";

    public void testParseJson() {
        assertEquals(2, PersitersTypeInfo.parseJsonContent(json).getPersisters().size());
    }

    public void testParseJsonForElasticsearch() {
        assertEquals("elasticsearch", PersitersTypeInfo.parseJsonContent(json).getPersisters().get(0).getType());
        assertEquals("esIndex", PersitersTypeInfo.parseJsonContent(json).getPersisters().get(0).getIndex());
        assertNotSame("falseUrl:234", PersitersTypeInfo.parseJsonContent(json).getPersisters().get(0).getBrokers());
    }

    public void testParseJsonForConsole() {
        assertEquals("console", PersitersTypeInfo.parseJsonContent(json).getPersisters().get(1).getType());
    }
}
