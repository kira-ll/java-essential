package com.kiratech.javaknow.classsample;

public class LocalClassExample {
    static String regularExpression = "[^0-9]";

    public static void validatePhoneNumber(String phoneNumber1,
                                           String phoneNumber2) {
        final int numberLength = 10;

        class PhoneNumber{
            String formattedPhoneNumber = null;

            public PhoneNumber(String phoneNumber) {
                String currentNumber = phoneNumber.replaceAll(regularExpression, "");
                if (currentNumber.length() == numberLength) {
                    formattedPhoneNumber = currentNumber;
                } else {
                    formattedPhoneNumber = null;
                }
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }

            public void printOriginalNumbers() {
                System.out.println("Original numbers are " + phoneNumber1
                + " and " + phoneNumber2);
            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        myNumber1.printOriginalNumbers();

        if (myNumber1.getNumber() == null) {
            System.out.println("first number is invalid.");
        }else {
            System.out.println("first number is " + myNumber1.getNumber());
        }
        if (myNumber2.getNumber() == null) {
            System.out.println("second number is invalid.");
        }else {
            System.out.println("second number is " + myNumber2.getNumber());
        }
    }

    public static void main(String[] args) {
        validatePhoneNumber("123-456-7890","456-7890");
    }
}
