package com.byodian.CaesarCipherAssignments;

import java.util.Random;

public class ArrayInAction {
    public static void main(String[] args) {
        textFingerPrint("Hello World!");
    }

    public static void textFingerPrint(String s) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] counters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = alpha.indexOf(Character.toLowerCase(ch));
            System.out.println("index: " + index );
            if (index != -1) {
                counters[index] += 1;
            }
        }

        for (int i = 0; i < counters.length; i++) {
            System.out.println(alpha.charAt(i) + "\t" + counters[i]);
        }
    }
}
