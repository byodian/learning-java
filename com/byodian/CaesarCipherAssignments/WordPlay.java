package com.byodian.CaesarCipherAssignments;

public class WordPlay {
    public static void main (String[] args) {
        tester();
    }

    public static boolean isVowel(Character ch) {
        String vowels = "aeiou";
        return vowels.contains(ch.toString().toLowerCase());
    }

    public static void tester() {
        System.out.println(isVowel('F'));
        System.out.println(isVowel('a'));
        System.out.println(isVowel('A'));
        System.out.println(replaceVowels("Hello World", '*'));
        System.out.println(emphasize("dna ctgaaactga", 'a'));
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }

    public static String replaceVowels(String phrase, char ch) {
        StringBuilder encryptedVowels = new StringBuilder(phrase);

        for (int i = 0; i < encryptedVowels.length(); i++) {
            char current = encryptedVowels.charAt(i);

            if (isVowel(current)) {
                encryptedVowels.setCharAt(i, ch);
            }
        }

        return encryptedVowels.toString();
    }

    public static String emphasize(String phrase, char ch) {
        StringBuilder encryptedPhrase = new StringBuilder(phrase);

        for (int i = 0; i < encryptedPhrase.length(); i++) {
            char current = encryptedPhrase.charAt(i);

            if (current == ch) {
                char encryptedChar = (i + 1) % 2 == 0 ? '+' : '*';
                encryptedPhrase.setCharAt(i, encryptedChar);
            }
        }

        return encryptedPhrase.toString();
    }
}
