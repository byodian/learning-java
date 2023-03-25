package com.byodian.StringsSecondAssignments;

public class Part1 {
    public static void main (String[] args) {
        //      testFindStopCodon();
        testFindGene();
        printAllGenes("TAAATGTAAATGTATTAGATGTTTTGA");
    }

    public static int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currentIndex = dna.indexOf(stopCodon, startIndex + 3);

        while (currentIndex != -1) {
            if ((currentIndex - startIndex) % 3 == 0) {
                return currentIndex;
            } else {
                currentIndex = dna.indexOf(stopCodon, currentIndex + 1);
            }
        }

        return dna.length();
    }

    public static void testFindStopCodon() {
        //            0123456789012345678901234567890
        //            ^  ^  ^  ^  ^  ^  ^  ^  ^  ^  ^
        String dna = "TTGATGATTAGGTAATTGAATTAAATGTATAA";
        int startIndex = dna.indexOf("ATG");

        int pos = findStopCodon(dna, 0, "TAA"); // 12
        if (pos != 12) { System.out.println("error on 12"); }
        pos = findStopCodon(dna, 12, "TAA"); // 21
        if (pos != 21) { System.out.println("error on 21"); }
        pos = findStopCodon(dna, 21, "TAA"); // 32
        if (pos != 32) { System.out.println("error on 32"); }

        System.out.println("Test finished");
    }

    public static String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) { return ""; }

        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex = Math.min(tgaIndex, Math.min(taaIndex, tagIndex));

        if (minIndex < dna.length()) {
            return dna.substring(startIndex, minIndex + 3);
        }
        return "";
    }

    public static void testFindGene() {
        String str1 = "ATATATAT";
        String str2 = "TTAATGAAATAT";
        String str3 = "TATATGTATTAA";
        String str4 = "TGAATGTATTAAAATTAG";
        String str5 = "TATATGTATTAGAATTAATGA";

        System.out.println("dna strand: " + str1);
        System.out.println("gene: " + findGene(str1, 0));

        System.out.println("dna strand: " + str2);
        System.out.println("gene: " + findGene(str2, 0));

        System.out.println("dna strand: " + str3);
        System.out.println("gene: " + findGene(str3, 0));

        System.out.println("dna strand: " + str4);
        System.out.println("gene: " + findGene(str4, 0));

        System.out.println("dna strand: " + str5);
        System.out.println("gene: " + findGene(str5, 0));
    }

    public static void printAllGenes(String dna) {
        int startIndex = 0;

        while (true) {
            String gene = findGene(dna, startIndex);

            if (gene.isEmpty()) {
                break;
            } else {
                System.out.println(gene);
                startIndex = dna.indexOf(gene) + gene.length();
            }
        }
    }
}
