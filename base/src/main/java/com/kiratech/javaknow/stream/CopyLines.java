package com.kiratech.javaknow.stream;

import java.io.*;

public class CopyLines {
    public static void main(String[] args) {
        BufferedReader in = null;
        PrintWriter out=null;

        try {
            in = new BufferedReader(new FileReader("xanadu.txt"));
            out = new PrintWriter(new FileWriter("xanadu-copy-line.txt"));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
