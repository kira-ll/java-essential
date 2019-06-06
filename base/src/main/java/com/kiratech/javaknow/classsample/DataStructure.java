package com.kiratech.javaknow.classsample;

import java.util.Iterator;

public class DataStructure {
    private final static int SIZE = 15;
    private int[] arrayOfInts = new int[SIZE];

    public DataStructure() {
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }

    public void printEven() {
        EvenIterator iter = this.new EvenIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    interface DataStructureIterator extends Iterator<Integer> {

    }

    private class EvenIterator implements DataStructureIterator{
        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return (nextIndex <= SIZE -1);
        }

        @Override
        public Integer next() {
            Integer retVal = Integer.valueOf(arrayOfInts[nextIndex]);
            nextIndex += 2;
            return retVal;
        }
    }

    public static void main(String[] args) {
        DataStructure ds = new DataStructure();
        ds.printEven();
    }
}
