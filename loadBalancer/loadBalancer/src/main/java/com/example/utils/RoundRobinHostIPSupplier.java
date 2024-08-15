package com.example.utils;

import java.util.List;

public class RoundRobinHostIPSupplier {

    //41.35.77.163
    private static final List<String> hosts = List.of("127.0.0.1", "localhost");
    private static int count = 0;

    public static String getHost() {
        //round-robin host selection
        int index = count % hosts.size();
        System.out.println("Host Selection index: " + index);
        String host = hosts.get(index);
        count++;
        return host;
    }
}
