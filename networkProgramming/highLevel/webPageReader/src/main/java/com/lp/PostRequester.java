package com.lp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class PostRequester {

    public static void main(String[] args) {
        try {
            //construct the URL
            URL url = new URL("https://reqbin.com/echo/post/json");
            //open the connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //configure the connection
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer {token}");
            conn.setRequestProperty("user-agent", "Application");
            //prepare the data
            String data = "{\n	\"employee\":{ \"name\":\"Emma\", \"age\":28, \"city\":\"Boston\" }\n} ";
            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
            //connect
            conn.connect();
            //send the data and get the response
            String response;
            try (OutputStream outputStream = conn.getOutputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                outputStream.write(bytes);
                response = reader.lines().collect(Collectors.joining("\n"));
            }
            //read the response
            System.out.println("Response Code: " + conn.getResponseCode());
            System.out.println("Response Message: " + conn.getResponseMessage());
            System.out.println("Response Body: " + response);
            //close the connection
            conn.disconnect();
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }
}
