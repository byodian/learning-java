package com.byodian.StringsSecondAssignments;

public class Part3 {
    public static void main (String[] args) {
        testCountGenes();
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

    public static int countGenes(String dna) {
        int startIndex = 0;
        int sum = 0;

        while (true) {
           String gene = findGene(dna, startIndex);

           if (gene.isEmpty()) {
               break;
           } else {
               sum = sum + 1;
               startIndex = dna.indexOf(gene) + gene.length();
           }
       }

       return sum;
    }

    public static void testCountGenes() {
        String str = "ATGTAAGATGCCCTAGT";
        System.out.println("The DNA strand: " + str);
        printAllGenes(str);
        System.out.println("How many genes: " + countGenes(str)); //

    }
}
