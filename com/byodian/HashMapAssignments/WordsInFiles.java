package com.byodian.HashMapAssignments;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;

public class WordsInFiles {
    private HashMap<String, ArrayList<String>> wordsMap;

    public WordsInFiles() {
        wordsMap = new HashMap<>();
    }

    public void addWordsFromFile(File f) {
        FileResource fr = new FileResource(f);
        for (String word : fr.words()) {
            if (!wordsMap.containsKey(word)) {
                ArrayList<String> filenameList = new ArrayList<>();
                filenameList.add(f.getName());
                wordsMap.put(word, filenameList);
            } else {
                wordsMap.get(word).add(f.getName());
            }
        }
    }

    public void buildWordFileMap() {
        wordsMap.clear();
        DirectoryResource files = new DirectoryResource();
        for (File f : files.selectedFiles()) {
            addWordsFromFile(f);
        }
    }

    public int maxNumber() {
        int maxNumber = 0;
        for (String key : wordsMap.keySet()) {
            int currentSize = wordsMap.get(key).size();
            if (currentSize > maxNumber) {
                maxNumber = currentSize;
            }
        }

        return maxNumber;
    }

    public ArrayList<String> wordsInNumFiles(int number) {
        ArrayList<String> words = new ArrayList<>();
        for (String key : wordsMap.keySet()) {
            if (wordsMap.get(key).size() == number) {
                words.add(key);
            }
        }

        return words;
    }

    public void printFilesIn(String word) {
        StringBuilder newString = new StringBuilder();
        for (String filename : wordsMap.get(word)) {
            newString.append(filename);
        }

        System.out.println(word + " appears in the files: " + newString.toString());
    }

    public void tester () {
        buildWordFileMap();
        System.out.println("maxNumber on those files would be " + maxNumber());

        for (String word : wordsInNumFiles(3)) {
            printFilesIn(word);
        }
    }

    public static void main(String[] args) {
        WordsInFiles myWordsInFiles = new WordsInFiles();
        myWordsInFiles.tester();
    }
}
