package com.byodian.CaesarCipherAssignments;

import edu.duke.FileResource;

import java.util.Random;
import java.util.Scanner;

public class ArrayInAction {
    public static void main(String[] args) {
        // textFingerPrint("Hello World!");
        // simpleSimulate(10);
        // test();
        countShakespeare();
    }

    public static void test() {
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

    static String[] getCommon() {
        FileResource fr = new FileResource("google-10000-english-no-swears.txt");
        String[] commons = new String[20];
        int index = 0;

        for (String word : fr.words()) {
            if (index < commons.length) {
                commons[index] = word;
                index += 1;
            }
        }

        return commons;
    }

    static int indexOf(String[] list, String word) {
        for (int k = 0; k < list.length; k++) {
            if (list[k].equals(word)) {
                return k;
            }
        }

        return -1;
    }

    static void countWords(FileResource resource, String[] commons, int[] counts) {
        for (String word : resource.words()) {
            int index = indexOf(commons, word);

            if (index != -1) {
                counts[index] += 1;
            }
        }
    }

    static void countShakespeare() {
        // String[] plays = { "caesar.txt", "errors.txt", "hamlet.txt", "likeit.txt", "macbeth.txt", "romeo.txt" };
        String[] plays = { "test.txt" };

        String[] common = getCommon();
        int[] counts = new int[common.length];

        for (String play : plays) {
            FileResource resource = new FileResource(play);
            countWords(resource, common, counts);
            System.out.println("done with " + play);
        }

        for (int k = 0; k < common.length; k++) {
            System.out.println(common[k] + "\t" + counts[k]);
        }
    }
}
