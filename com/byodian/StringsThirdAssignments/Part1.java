package com.byodian.StringsThirdAssignments;

import static com.byodian.StringsSecondAssignments.Part1.findGene;
import edu.duke.StorageResource;

public class Part1 {
    public static void main(String[] args) {
        StorageResource geneList = getAllGenes("TAATGTAATGTAGTGAATGTGA");
        for(String gene : geneList.data()) {
            System.out.println(gene);
        }

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
}
