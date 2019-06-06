package com.kiratech.javaknow.net;

import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.URL;

public class HttpClientExample {
    public static void UrlRequest(URL url) {
        try {
            HttpClient httpClient = HttpClient.New(url);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
