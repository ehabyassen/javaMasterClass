package com.lp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class WebPageReader {

    public static void main(String[] args) {
        String urlString = "http://example.org";
        String res1 = readPageUsingUrlInputStream(urlString);
        String res2 = readPageUsingUrlConnection(urlString);
        System.out.println(res1.equals(res2));
    }

    private static String readPageUsingUrlConnection(String urlString) {
        String webPageHtml = "";
        try {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            conn.connect();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                webPageHtml = reader.lines().collect(Collectors.joining("\n"));
            }
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception:" + e.getMessage());
        }
        return webPageHtml;
    }

    private static String readPageUsingUrlInputStream(String urlString) {
        String webPageHtml = "";
        try {
            URL url = new URL(urlString);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                webPageHtml = reader.lines().collect(Collectors.joining("\n"));
            } catch (IOException e) {
                System.out.println("IO Exception:" + e.getMessage());
            }
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL:" + e.getMessage());
        }
        return webPageHtml;
    }
}
