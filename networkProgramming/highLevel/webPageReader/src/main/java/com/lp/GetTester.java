package com.lp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetTester {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Chrome");
            conn.setReadTimeout(10000);

            //connect is implicitly called by getInputStream and getResponseCode
            //conn.connect();

            System.out.println("Response Code: " + conn.getResponseCode());

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                reader.lines().forEach(System.out::println);
            }

            conn.disconnect();
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
