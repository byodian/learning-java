package com.byodian.StringsThirdAssignments;

import static com.byodian.StringsSecondAssignments.Part1.findGene;
import edu.duke.FileResource;
import edu.duke.StorageResource;

import java.io.File;

public class Part1 {
    public static void main(String[] args) {
        // testGetAllGenes();
        // testCGRatioAndCountCTG();

        // testProcessGenes();
        testProcessGenesWithFile();
    }

    public static StorageResource getAllGenes(String dna) {
        int startIndex = 0;
        StorageResource geneList = new StorageResource();

        while (true) {
            String gene = findGene(dna, startIndex);

            if (gene.isEmpty()) {
                break;
            } else {
                geneList.add(gene);
                startIndex = dna.indexOf(gene) + gene.length();
            }
        }

        return geneList;
    }

    public static void testGetAllGenes() {
        StorageResource geneList = getAllGenes("TAATGTAATGTAGTGAATGTGA");
        for(String gene : geneList.data()) {
            System.out.println(gene);
        }
    }

    public static double cgRatio(String dna) {
        int cgSum = 0 ;
        for(int i = 0; i < dna.length(); i++) {
            char c = dna.charAt(i);
            if (c == 'C' || c == 'G') {
                cgSum = cgSum + 1;
            }
        }

        return ((double) cgSum) / dna.length();
    }

    public static int countCTG(String dna) {
        int currentIndex = dna.indexOf("CTG");
        int count = 0;
        while (currentIndex != -1) {
            count = count + 1;
            currentIndex = dna.indexOf("CTG", currentIndex + 3);
        }

        return count;
    }

    public static void testCGRatioAndCountCTG() {
        System.out.println(cgRatio("ATGCCATAG")); // 4/9 0.44444...
        //                                ^     ^     ^  ^    ^
        System.out.println(countCTG("CTGATACTGATACTGCTGATCTG"));
    }

    public static void processGenes(StorageResource sr) {
        // the number of Strings in sr are longer than 9 characters
        int sum1 = 0;
        // the number of strings in sr whose C-G-ratio is higher than 0.35
        int sum2 = 0;
        int maxLengthGene = 0;
        for(String s : sr.data()) {
            if (s.length() > 9) {
               System.out.println("gene in sr which longer than 9 characters: \n" + s + "\n");
               sum1 = sum1 + 1;
            }

            if (cgRatio(s) > 0.35) {
                System.out.println("gene in sr whose C-G-ratio is higher than 0.35: \n" + s + "\n");
                sum2 = sum2 +1;
            }

           maxLengthGene = Math.max(maxLengthGene, s.length());
        }

        System.out.println("the number of Strings in sr are longer than 9 characters: " + sum1);
        System.out.println("the number of strings in sr whose C-G-ratio is higher than 0.35: " + sum2);
        System.out.println("the length of the longest gene in sr: " + maxLengthGene);
    }

    public static void testProcessGenes() {
        String str1 = "ATAATGT";
        String str2 = "ATGTTTAATTAAATGATTTAA";
        String str3 = "ATGCCCGGGTAAATGCGCATGTGA";
        String str4 = "ATGATTAGATAA";
        processGenes(getAllGenes(str1));
        processGenes(getAllGenes(str2));
        processGenes(getAllGenes(str3));
        processGenes(getAllGenes(str4));
    }

    public static void testProcessGenesWithFile() {
        FileResource fr = new FileResource("dnaline.fa");
        String dna = fr.asString();
        processGenes(getAllGenes(dna.toUpperCase()));
    }
}
