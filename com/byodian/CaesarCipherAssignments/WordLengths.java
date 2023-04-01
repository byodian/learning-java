package com.byodian.CaesarCipherAssignments;

import edu.duke.FileResource;

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

    public static void countWordLengths2(FileResource resource, int[] counts) {
        for (String word : resource.words()) {
            String cleanWord = word.replaceAll("^[^a-zA-Z]+|[^a-zA-Z]$", "");
            int len = cleanWord.length();

            if (len >= counts.length) {
                counts[len - 1] += 1;
            } else {
               counts[len] += 1;
            }
        }
    }

    public static void testCountWordLengths() {
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        countWordLengths(fr, counts);
        System.out.println("the index position of the largest element in values " + indexOfMax(counts));

        for (int k = 1; k < counts.length; k++) {
            System.out.println(counts[k] + " words of length " + k);
        }
    }

    public static int indexOfMax(int[] values) {
        if (value == null || values.length = 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        int maxIndex = 0;

        for (int k = 0; k < values.length; k++) {
            if (values[k] > values[maxIndex]) {
                maxIndex = k;
            }
        }

        return maxIndex;
    }
}
