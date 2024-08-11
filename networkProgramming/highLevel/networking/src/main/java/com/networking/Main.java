package com.networking;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
            URI absoluteURI = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
            printURI(absoluteURI);

            System.out.println("=".repeat(50));

            URL url = absoluteURI.toURL();
            System.out.println("URL: " + url);

            System.out.println("=".repeat(50));

//            URI baseUri = new URI("http://username:password@myserver.com:5000");
            URI baseUri = new URI("http://username:password@mynewserver.com:5000");
            URI relativeURI1 = new URI("/catalogue/phones?os=android#samsung");
//            URL url = relativeURI.toURL(); throws exception: URI is not absolute
            URI resolvedURI1 = baseUri.resolve(relativeURI1);
            URL url1 = resolvedURI1.toURL();
            System.out.println("URL: " + url1);

            //test one base URI, multi relative URIs
            URI relativeURI2 = new URI("/catalogue/tvs?manufacturer=samsung");
            URI relativeURI3 = new URI("/stores/locations?zip=12345");
            URI resolvedURI2 = baseUri.resolve(relativeURI2);
            URI resolvedURI3 = baseUri.resolve(relativeURI3);
            System.out.println("URL: " + resolvedURI2.toURL());
            System.out.println("URL: " + resolvedURI3.toURL());

            URI relativizedURI2 = baseUri.relativize(resolvedURI2);
            System.out.println("Relative URL2: " + relativeURI2);

        } catch (URISyntaxException e) {
            System.out.println("URI bad syntax: " + e.getMessage());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static void printURI(URI uri) {
        System.out.println("Scheme: " + uri.getScheme());
        System.out.println("Scheme-specific part: " + uri.getSchemeSpecificPart());
        System.out.println("Authority: " + uri.getAuthority());
        System.out.println("User info: " + uri.getUserInfo());
        System.out.println("Host: " + uri.getHost());
        System.out.println("Port: " + uri.getPort());
        System.out.println("Path: " + uri.getPath());
        System.out.println("Query: " + uri.getQuery());
        System.out.println("Fragment: " + uri.getFragment());
    }
}
