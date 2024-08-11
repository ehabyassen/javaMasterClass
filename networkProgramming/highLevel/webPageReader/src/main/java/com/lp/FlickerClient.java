package com.lp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FlickerClient {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=dogs");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("User-Agent", "Chrome");

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            if (responseCode != 200) {
                System.out.println("Response Message: " + conn.getResponseMessage());
                return;
            }

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
