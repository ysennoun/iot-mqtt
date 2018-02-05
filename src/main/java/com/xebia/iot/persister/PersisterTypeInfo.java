package com.xebia.iot.persister;

public class PersisterTypeInfo {

    private String type;
    private String brokers = "";
    private String index = "";

    public String getType() {
        return this.type;
    }

    public String getBrokers() {
        return this.brokers;
    }

    public String getIndex() { return this.index;
    }
}
