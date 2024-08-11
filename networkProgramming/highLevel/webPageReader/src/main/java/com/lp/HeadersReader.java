package com.lp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HeadersReader {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.org/");
            System.out.println(url.getPath());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();

            Map<String, List<String>> headerFields = conn.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                String key = entry.getKey();
                System.out.println("----Key: " + key);
                for (String headerValue : entry.getValue()) {
                    System.out.println("--------value: " + headerValue);
                }
            }

            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
