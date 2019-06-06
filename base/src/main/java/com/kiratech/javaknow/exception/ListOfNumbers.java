package com.kiratech.javaknow.exception;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {
    private List<Integer> list;
    private static final Integer SIZE = 10;
    private static final Integer SIZEE = 11;

    public ListOfNumbers() {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(new Integer(i));
        }
    }

    public void writList() {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("outfile.txt"));
            for (int i = 0; i < SIZEE; i++) {
                out.println("Value at " + i + " is " + list.get(i));
            }
        } catch (IOException e) {
            System.out.println("ioexception." + e.getMessage());
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("indexoutofboundsexception." + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("exception." + e.getMessage());
            e.printStackTrace();
        } finally {
            if (out != null) {
                System.out.println("finally file close.");
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("file not open.");
            }
        }
    }

    public static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(path))) {
            return reader.readLine();
        }
    }

    public static String readFirstLineFromFileWithFinally(String path) throws IOException {
        BufferedReader reader =
                new BufferedReader(new FileReader(path));
        try {
            return reader.readLine();
        } finally {
            if (reader != null) reader.close();
        }
    }

    public static void main(String[] args) {
        ListOfNumbers listOfNumbers = new ListOfNumbers();
        listOfNumbers.writList();

        String path = "outfile.txt";
        try {
            System.out.println(readFirstLineFromFile(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Throwable e = new Exception();
    }
}
