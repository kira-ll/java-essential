package com.kiratech.javaknow.base;

import java.util.HashMap;

public class HashMap1 {
    public static HashMap<String,String> userAgeMap;

    public HashMap1() {
        userAgeMap = new HashMap<String, String>();
    }

    public void setUserAgeMap(String key, String value){
        userAgeMap.put(key,value);
    }

    public String getUserAgeMap(String key){
        return userAgeMap.get(key);
    }

    public static void main(String[] args){
        HashMap1 map1 = new HashMap1();
        String name = "liu";
        String age = "18";
        map1.setUserAgeMap(name,age);
        System.out.println(map1.getUserAgeMap(name));
    }
}
