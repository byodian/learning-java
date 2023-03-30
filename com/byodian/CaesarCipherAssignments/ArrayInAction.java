package com.byodian.CaesarCipherAssignments;

import java.util.Random;
import java.util.Scanner;

public class ArrayInAction {
    public static void main(String[] args) {
        // textFingerPrint("Hello World!");
        // simpleSimulate(10);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scan.nextInt();
        scan.close();
        simpleSimulateWithArrays(num);
    }

    public static void textFingerPrint(String s) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] counters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = alpha.indexOf(Character.toLowerCase(ch));

            if (index != -1) {
                counters[index] += 1;
            }
        }

        for (int i = 0; i < counters.length; i++) {
            System.out.println(alpha.charAt(i) + "\t" + counters[i]);
        }
    }

    // long version
    public static void simpleSimulate(int rolls) {
        Random rand = new Random();
        int two = 0;
        int twelves = 0;

        for (int k = 0; k < rolls; k++) {
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;
            if (d1 + d2 == 2) {
                two += 1;
            } else if (d1 + d2 == 12) {
                twelves += 1;
            }
        }

        System.out.println("2's=\t" + two + "\t" + 100.0 * two/rolls);
        System.out.println("12's=\t" + twelves + "\t" + 100.0 * twelves/rolls);
    }

    public static void simpleSimulateWithArrays(int rolls) {
        Random rand = new Random();
        int[] results = new int[13];

        for (int k = 0; k < rolls; k++) {
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;
            results[d1 + d2] += 1;
        }

        for (int i = 0; i < results.length; i++) {
            System.out.println(i + "'s=\t" + results[i] + "\t" + 100.0 * results[i]/rolls);
        }
    }
}
