package com.lp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class HeadTester {

    /*
    * HEAD is a method of the HTTP protocol which is similar to GET except that the server only returns
    * message-headers in the response, without a message-body. This is useful for retrieving meta-data
    * written in response headers, without having to transport the entire content.
     */
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.org");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.setRequestProperty("user-agent", "Application");
            conn.connect();

            System.out.println("Response Code: " + conn.getResponseCode());
            System.out.println("Response Message: " + conn.getResponseMessage());

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String response = reader.lines().collect(Collectors.joining("\n"));
                System.out.println("Response Body: " + response);
            }

            conn.getHeaderFields().forEach((key, value) -> {
                System.out.println(key + ": " + value);
            });

            conn.disconnect();
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }
}
