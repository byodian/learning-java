package com.byodian.MostFrequentWrodAssignments;

import edu.duke.FileResource;

import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    public WordFrequencies () {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    public void findUnique() {
        myWords.clear();
        myFreqs.clear();

        FileResource resource = new FileResource();
        for (String word : resource.words()) {
            String newWord = word.toLowerCase();
            int index = myWords.indexOf(newWord);
            if (index == -1) {
                myWords.add(newWord);
                myFreqs.add(1);
            } else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value + 1);
            }
        }
    }

    public int findIndexOfMax() {
        int indexOfMax = 0;
        for (int i = 0; i < myFreqs.size(); i++) {
            if (myFreqs.get(i) > myFreqs.get(indexOfMax)) {
                indexOfMax = i;
            }
        }

        return indexOfMax;
    }

    public void tester () {
        findUnique();
        int numbers = myWords.size();
        System.out.println("Number of unique words: " + numbers);

        for (int i = 0; i < numbers; i++) {
            System.out.println(myFreqs.get(i) + " " + myWords.get(i));
        }

        int indexOfMax = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: " + myWords.get(indexOfMax) + " " + myFreqs.get(indexOfMax));
    }

    public static void main(String[] args) {
        WordFrequencies freqs = new WordFrequencies();
        freqs.tester();
    }
}