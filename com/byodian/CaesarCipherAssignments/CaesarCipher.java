package com.byodian.CaesarCipherAssignments;

import edu.duke.FileResource;

public class CaesarCipher {
    public static void main(String[] args) {
        // testCaesar();
        test();
    }

    public static void testCaesar() {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("Key is " + key + "\n" + encrypted);
    }

    public static void test() {
        System.out.println("key is: 23 " + encrypt("First Legion", 23));
        System.out.println("key is: 23 " + encrypt("First Legion", 17));
        System.out.println("key is: 23 " + encryptTwoKeys("First Legion", 23, 17));
    }

    // handle both uppercase and lowercase letters
    // long version (good)
    public static String encrypt1(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String upperCaseAlphabet = lowerCaseAlphabet.toUpperCase();

        String shiftedLowerCaseAlphabet = lowerCaseAlphabet.substring(key) + lowerCaseAlphabet.substring(0, key);
        String shiftedUpperCaseAlphabet = upperCaseAlphabet.substring(key) + upperCaseAlphabet.substring(0, key);

        for (int i = 0; i < encrypted.length(); i++) {
            char currentChar = encrypted.charAt(i);
            int idx1 = lowerCaseAlphabet.indexOf(currentChar);
            int idx2 = upperCaseAlphabet.indexOf(currentChar);

            if (idx1 != -1) {
                encrypted.setCharAt(i, shiftedLowerCaseAlphabet.charAt(idx1));
            }

            if (idx2 != -1) {
                encrypted.setCharAt(i, shiftedUpperCaseAlphabet.charAt(idx2));
            }
        }

        return encrypted.toString();
    }


    // short version (better)
    public static String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);

        for (int i = 0; i < encrypted.length(); i++) {
            char currentChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currentChar));

            if (idx != -1) {
                char shiftedChar = shiftedAlphabet.charAt(idx);
                char newChar = Character.isLowerCase(currentChar) ? Character.toLowerCase(shiftedChar): shiftedChar;
                encrypted.setCharAt(i, newChar);
            }
        }

        return encrypted.toString();
    }

    public static String encryptTwoKeys(String input, int key1, int key2) {

        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String shiftedOddAlphabet = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedEvenAlphabet = alphabet.substring(key2) + alphabet.substring(0, key2);

        for (int i = 0; i < encrypted.length(); i++) {
            char currentChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currentChar));

            if (idx != -1) {
                char shiftedChar = (i + 1) % 2 == 0 ? shiftedOddAlphabet.charAt(idx): shiftedEvenAlphabet.charAt(idx);
                char newChar = Character.isLowerCase(currentChar) ? Character.toLowerCase(shiftedChar): shiftedChar;
                encrypted.setCharAt(i, newChar);
            }
        }

        return encrypted.toString();
    }
}
