package com.byodian.HashMapAssignments;

import edu.duke.FileResource;

import java.util.HashMap;

public class CodonCount {
    private HashMap<String, Integer> map;
    public CodonCount() {
        map = new HashMap<String, Integer>();
    }

    public void buildCodonMap(int start, String dna) {
        map.clear();
        int k = start;
        while (k + 3 < dna.length()) {
            String key = dna.substring(k, k + 3);
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }

            k += 3;
        }
    }

    public String getMostCommonCodon() {
        String codonOfMaxCount = "";

        for (String key : map.keySet()) {
            if (codonOfMaxCount.isEmpty() || map.get(key) > map.get(codonOfMaxCount)) {
                codonOfMaxCount = key;
            }
        }

        return codonOfMaxCount;
    }

    public void printCodonCounts(int start, int end) {
        for (String key : map.keySet()) {
            int currentCount = map.get(key);
            if (currentCount >= start && currentCount <= end) {
                System.out.println(key + "\t" + currentCount);
            }
        }
    }

    public void tester() {
        FileResource fr = new FileResource();

        for (int i = 0; i < 3; i++) {
            buildCodonMap(i, fr.asString().toUpperCase());
            String mostCommonCodon = getMostCommonCodon();
            System.out.println("Reading frame starting with " + i + " results in " + map.size() + " unique codons");
            System.out.println(" and most common codon is " + mostCommonCodon + " with count " + map.get(mostCommonCodon));
            System.out.println("Counts of codons between 1 and 5 inclusive are:");
            printCodonCounts(1, 5);
        }
    }

    public static void main(String[] args) {
        CodonCount myCodonCount = new CodonCount();
        myCodonCount.tester();
    }
}
