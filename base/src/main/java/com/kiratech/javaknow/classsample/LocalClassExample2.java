package com.kiratech.javaknow.classsample;

public class LocalClassExample2 {
    public void greetInEnglish1() {

        //cannot declare an interface inside a block.
//        interface Hello{
//            public void greet();
//        }

//        class EnglishHello implements Hello{
        class EnglishHello {
            public void greet() {
                System.out.println("hello instance greet().");
            }
        }

        EnglishHello hello = new EnglishHello();
        hello.greet();
    }


//    You cannot declare static initializers or member interfaces in a local class
//    public void greetInEnglish2() {
//
//        class EnglishHello {
//            public  static void greet() {
//                System.out.println("hello static greet().");
//            }
//        }
//
//        EnglishHello.greet();
//    }

    public void greetInEnglish3() {

        class EnglishHello {
            public static final String farewell = "hello static members greet().";
            public void greet() {
                System.out.println(farewell);
            }
        }
        EnglishHello hello = new EnglishHello();
        hello.greet();
    }

    public static void main(String[] args) {
        LocalClassExample2 example = new LocalClassExample2();
        example.greetInEnglish1();

//        example.greetInEnglish2();

        example.greetInEnglish3();

        MyHello hello = new MyHello();
        hello.greet();

    }
}
