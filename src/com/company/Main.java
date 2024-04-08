package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // --- 1
        String[] s1 = {"a", "rex", "book", "fix"};
        System.out.println(maxString(s1));

        // --- 2
        String s21 = "Мы же на ты", s22 = "Мы же на ты";
        System.out.println(polindrom(s21, s22));

        // --- 3
        String s3 = "Our seller is the last bastard, he sold a poor product to a burdock the customer...";
        String[] banList = {"bastard", "poor", "burdock"};
        System.out.println(cenzur(banList, s3));

        // --- 4
        String s4 = "the";
        System.out.println(occurrences(s3, s4));

        // --- 5
        System.out.println(statistic(s3));

    }

    // --- 1
    public static String maxString(String[] s1){
        String max = "";

        for (String s : s1){
            if (max.length() < s.length()){
                max = s;
            }
        }

        return max;
    }

    // --- 2
    public static boolean polindrom(String s1, String s2){
        s1 = s1.replaceAll(" ", "");
        s2 = s2.replaceAll(" ", "");

        if(s1.equals(s2)){
            return true;
        }

        return false;
    }

    // --- 3
    public static String cenzur(String[] banList, String s1){
        for (String s: banList){
            s1 = s1.replaceAll(s, "[cut out by censorship]");
        }
        return s1;
    }

    // --- 4
    public static int occurrences(String str, String substr) {
        int occurrences = 0;
        int index = str.indexOf(substr);

        while (index != -1) {
            occurrences++;
            index = str.indexOf(substr, index + 1);
        }

        return occurrences;
    }

    // --- 5
    public static String statistic(String str){
        char[] charArray = str.toCharArray();
        Map<Character, Integer> map = new HashMap();

        for (char c: charArray){
                if (map.get(c) != null){
                    map.put(c, map.get(c)+1);
                }else {
                    map.put(c, 1);
                }
        }

        str = "";

        for (Character key : map.keySet()){
            str = str + key + " - " + map.get(key) + " | ";
        }

        return str;
    }

}
