package com.kiratech.javaknow.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;
        byte[] bb = new byte[200];

        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("xanadu-copy.txt");
            int c;
            //c是一个整型的低8bits
//            while ((c = in.read()) != -1) {
//                System.out.println("c is:"+c);
//                out.write(c);
//            }
            c = in.read(bb);
            for (int i = 0; i < c; i++) {
                System.out.println("bb " + i + " is " + bb[i]);
            }
        } catch (IOException e) {
            System.out.println("ioexception:" + e.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("ioexception:" + e.getMessage());
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("ioexception:" + e.getMessage());
                }
            }
        }

    }
}
