package com.kiratech.javaknow.stream;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

public class passwordConsole {
    public static void main(String[] args) throws IOException {
        Console s = System.console();
        if (s == null) {
            System.out.println("console not avaliable.");
            System.exit(-1);
        }

        String login = s.readLine("enter your username:");
        char[] oldPass = s.readPassword("enter your old password:");
        if (verifyPass(login, oldPass)) {

            boolean noMatch = true;
            do {
                char[] newPass1 = s.readPassword("enter your new password:");
                char[] newPass2 = s.readPassword("enter your new password again:");
                noMatch = !Arrays.equals(newPass1, newPass2);
                if (noMatch) {
                    s.format("try again.%n");
                } else {
                    changePass(login,newPass1);
                    s.format("password for %s changed.%n",login);
                }
                Arrays.fill(newPass1,' ');
                Arrays.fill(newPass2,' ');
            } while (noMatch);
        }
        Arrays.fill(oldPass,' ');
    }

    public static boolean verifyPass(String login, char[] password) {
        return true;
    }

    public static void changePass(String login, char[] newPass) {

    }

}
