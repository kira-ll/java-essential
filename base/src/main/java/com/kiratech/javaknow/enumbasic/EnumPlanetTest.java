package com.kiratech.javaknow.enumbasic;

public class EnumPlanetTest {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage:java Planet<earth_weight>");
            System.exit(-1);
        }
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Your weight on %s is %f%n",
                    p,p.surfaceWeight(mass));
        }

    }
}
