package com.lp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PublicIPReader {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://ifconfig.me");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            System.out.println("Response code: " + conn.getResponseCode());
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                reader.lines().forEach(System.out::println);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
