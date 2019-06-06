package com.kiratech.javaknow.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLExample {
    public static void main(String[] args) throws Exception {
        URL url = null;
        try {
            url = new URL("http://example.com:80/docs/books/tutorial" +
                    "/index.html?name=networking#DOWNLOADING");
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("protocol:" + url.getProtocol());
        System.out.println("authority:" + url.getAuthority());
        System.out.println("host:" + url.getHost());
        System.out.println("port:" + url.getPort());
        System.out.println("path:" + url.getPath());
        System.out.println("query:" + url.getQuery());
        System.out.println("filename:" + url.getFile());
        System.out.println("ref:" + url.getRef());

//        URLReader.OracleUrlReader();

        URLConnExample.openConn();

    }

    static class URLReader {
        public static void OracleUrlReader() throws Exception {
            URL url = new URL("https://www.baidu.com/");
            System.out.println(url.toString());
            String line;

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()))) {
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class URLConnExample {
        public static void openConn() {
            BufferedReader in = null;
            try {
                URL url = new URL("https://www.baidu.com/");
                URLConnection conn = url.openConnection();
                System.out.println(conn.toString());
//                conn.connect();
                in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                String line = null;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
