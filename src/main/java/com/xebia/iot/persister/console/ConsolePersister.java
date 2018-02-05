package com.xebia.iot.persister.console;

import com.xebia.iot.persister.Persister;

public class ConsolePersister extends Persister{

    public void persiste(String data) {
        System.out.println(data);
    }
}
