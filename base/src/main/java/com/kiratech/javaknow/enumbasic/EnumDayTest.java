package com.kiratech.javaknow.enumbasic;

public class EnumDayTest {
    Day day;

    public EnumDayTest(Day day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (day) {
            case FRIDAY:
                System.out.println("Friday.");
                break;
            case TUESDAY:
                System.out.println("Tuesday.");
                break;
            case MONDAY:
                System.out.println("Monday.");
                break;
            default:
                System.out.println("default.");
                break;
        }
    }

    public static void main(String[] args) {
        EnumDayTest day1 = new EnumDayTest(Day.MONDAY);
        day1.tellItLikeItIs();
        day1 = new EnumDayTest(Day.WEDNESDAY);
        day1.tellItLikeItIs();

        System.out.println(Day.MONDAY);
        System.out.println(Day.valueOf("MONDAY"));

        for (Day d1 : Day.values()) {
            System.out.println(d1);
        }
    }
}
