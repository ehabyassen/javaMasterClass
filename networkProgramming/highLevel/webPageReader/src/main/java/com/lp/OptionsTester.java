package com.lp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class OptionsTester {

    /*
    * The OPTIONS method represents a request for information about the communication options available on the request/response
    * chain identified by the Request-URI. This method allows the client to determine the options and/or requirements associated
    * with a resource, or the capabilities of a server, without implying a resource action or initiating a resource retrieval.
     */
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.reqbin.com");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("OPTIONS");
            conn.setRequestProperty("user-agent", "Application");
            conn.connect();

            System.out.println("Response Code: " + conn.getResponseCode());
            System.out.println("Response Message: " + conn.getResponseMessage());
            System.out.println("Allowed Methods: " + conn.getHeaderField("Allow"));

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
