package com.kiratech.javaknow.net;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class HttpClientCommons {
    public static String url = "https://www.baidu.com";

    public static void main(String[] args) {

        post(url);

    }

    public static void getbytes(String url) {
        HttpClient httpClient = new HttpClient();
        GetMethod method = new GetMethod(url);

        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));

        try {
            int statusCode = httpClient.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("Method failed." + method.getStatusLine());
            }
            byte[] response = method.getResponseBody();
            System.out.println(new String(response));
        } catch (HttpException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
    }

    public static void post(String url) {
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(url);

        try {
            setReqHeaders(method);

            Header[] requestHeaders = method.getRequestHeaders();
            if (requestHeaders != null) {
                System.out.println("request headers before method execute:");
                for (Header header : requestHeaders) {
                    System.out.println(header.getName() + ":" + header.getValue());
                }
            }

            method.setParameter("k1","v1");
            method.setRequestBody(setReqBody());
            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("Method failed." + method.getStatusLine());
            }

            Header[] requestHeaders1 = method.getRequestHeaders();
            if (requestHeaders1 != null) {
                System.out.println("request headers after method execute:");
                for (Header header : requestHeaders1) {
                    System.out.println(header.getName() + ":" + header.getValue());
                }
            }
            System.out.println("uri:"+method.getURI());
            System.out.println("query string:"+method.getQueryString());

            InputStream in = method.getResponseBodyAsStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            System.out.println("response body:");
            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
            }

            Header[] headers = method.getResponseHeaders();
            if (headers != null) {
                System.out.println("response headers:");
                for (Header header : headers) {
                    System.out.println(header.getName() + ":" + header.getValue());
                }
            }

        } catch (HttpException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
        }
    }

    public static void setReqHeaders(HttpMethod method) {
        ArrayList<Header> headers = new ArrayList<>();
        Header header = new Header();
        header.setName("req1");
        header.setValue("req1-v");
        headers.add(header);

        method.setRequestHeader(header);

        method.setRequestHeader("req2","req2-v");
    }

    public static NameValuePair[] setReqBody() {
        ArrayList<NameValuePair> bodys = new ArrayList<>();
        NameValuePair pair = new NameValuePair("name1", "v1");
        bodys.add(pair);

        return (NameValuePair[])bodys.toArray(new NameValuePair[bodys.size()]);
    }
}
