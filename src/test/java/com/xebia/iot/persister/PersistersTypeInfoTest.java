package com.xebia.iot.persister;

import junit.framework.TestCase;

public class PersistersTypeInfoTest extends TestCase {

    private String json = "{\"persisters\":" +
            "[{\"type\":\"elasticsearch\",\"brokers\":\"url1:123,url2:321\",\"index\":\"esIndex\"}," +
            "{\"type\":\"console\",\"brokers\":\"\",\"index\":\"\"}]}";

    public void testParseJson() {
        System.out.println("--BEGIN TEST--");
        System.out.println("Test on PersistesTypeInfo : find 2 persisters");
        assertEquals(2, PersitersTypeInfo.parseJsonContent(json)
                .getPersisters().size()
        );
        System.out.println("--END--");
    }

    public void testParseJsonForElasticsearch() {
        System.out.println("--BEGIN TEST--");
        System.out.println("Test on PersistesTypeInfo : type same than elasticsearch");
        assertEquals("elasticsearch", PersitersTypeInfo.parseJsonContent(json)
                .getPersisters().get(0).getType()
        );
        System.out.println("Test on PersistesTypeInfo : index same than esIndex");
        assertEquals("esIndex", PersitersTypeInfo.parseJsonContent(json)
                .getPersisters().get(0).getIndex()
        );
        System.out.println("Test on PersistesTypeInfo : url not");
        assertNotSame("falseUrl:234", PersitersTypeInfo.parseJsonContent(json)
                .getPersisters().get(0).getBrokers()
        );
        System.out.println("--END--");
    }

    public void testParseJsonForConsole() {
        System.out.println("--BEGIN TEST--");
        System.out.println("Test on PersistesTypeInfo : type same than console");
        assertEquals("console", PersitersTypeInfo.parseJsonContent(json)
                .getPersisters().get(1).getType()
        );
        System.out.println("--END--");
    }
}
