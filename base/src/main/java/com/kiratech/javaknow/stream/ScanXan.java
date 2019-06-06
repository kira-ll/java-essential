package com.kiratech.javaknow.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScanXan {

    public static void main(String[] args) {
        Scanner s = null;
        try {
            s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
        }

        scanSum();

    }

    public static void scanSum(){
        Scanner su =null;
        double sum = 0;
        try {
            su = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
            while (su.hasNext()) {
                if (su.hasNextDouble()) {
                    sum = sum+su.nextDouble();
                }else {
                    su.next();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (su != null) {
                su.close();
            }
        }

        System.out.println(sum);
    }

}
