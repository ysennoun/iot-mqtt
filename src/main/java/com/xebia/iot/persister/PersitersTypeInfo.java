package com.xebia.iot.persister;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class PersitersTypeInfo {

    private ArrayList<PersisterTypeInfo> persisters;

    public ArrayList<PersisterTypeInfo>  getPersisters() {
        return persisters;
    }

    public static PersitersTypeInfo parseJsonContent(String json) {
        PersitersTypeInfo result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            result = objectMapper.readValue(json, PersitersTypeInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}


