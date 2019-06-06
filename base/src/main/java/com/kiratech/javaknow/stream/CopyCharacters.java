package com.kiratech.javaknow.stream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) {
        FileReader in = null;
        FileWriter out = null;
        char[] cb = new char[200];

        try {
            in = new FileReader("xanadu.txt");
            out = new FileWriter("xanadu-copy-char.txt");
            int c;
//            while ((c=in.read())!=-1){
//                System.out.println("c is:"+c);
//                out.write(c);
//            }
            c = in.read(cb);
            for (int i = 0; i < c; i++) {
                System.out.println("cb " + i + " is " + cb[i]);
            }
            String str = new String(cb);
            System.out.println("cb string is:" + str.toString());
            byte[] bb = str.getBytes();
            for (int j = 0; j < bb.length; j++) {
                System.out.println("bb " + j + " is " + bb[j]);
            }
        } catch (IOException e) {
            System.out.println("ioexception:" + e.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("in ioexception:" + e.getMessage());
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("out ioexception:" + e.getMessage());
                }
            }
        }
    }
}
