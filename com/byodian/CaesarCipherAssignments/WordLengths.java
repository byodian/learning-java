package com.byodian.CaesarCipherAssignments;

import edu.duke.FileResource;

import java.io.File;
import java.util.function.Function;

public class WordLengths {
    public static void main(String[] args) {
        testCountWordLengths();
    }

    // long version
    public static void countWordLengths(FileResource resource, int[] counts) {
        for (String word : resource.words()) {
                int len = word.length();
                if (!Character.isLetter(word.charAt(0))) {
                    len -= 1;
                }

                if (!Character.isLetter(word.charAt(word.length() - 1))) {
                    len -= 1;
                }

                if (len >= counts.length) {
                    counts[counts.length - 1]  += 1;
                } else {
                    counts[len]  += 1;
                }
        }
    }

    public static void testCountWordLengths() {
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        countWordLengths(fr, counts);

        for (int k = 1; k < counts.length; k++) {
            System.out.println(counts[k] + " words of length " + k);
        }
    }
}
