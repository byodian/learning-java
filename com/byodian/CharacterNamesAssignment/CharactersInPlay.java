package com.byodian.CharacterNamesAssignment;

import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> characters;
    private ArrayList<Integer> counts;

    public CharactersInPlay() {
        characters = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }

    public void update(String name) {
        int index = characters.indexOf(name);

        if (index == -1) {
            characters.add(name);
            counts.add(1);
        } else {
            int value = counts.get(index);
            counts.set(index, value + 1);
        }
    }

    public void findAllCharacters() {
        characters.clear();
        counts.clear();

        FileResource fr = new FileResource();
        for (String line : fr.lines()) {
            int indexOfPeriod = line.indexOf(".");

            if (indexOfPeriod != -1) {
                String newLine = line.substring(0, indexOfPeriod);
                update(newLine);
            }
        }
    }

    public void tester() {
        findAllCharacters();
        for (int i = 0; i < characters.size(); i++) {
            int number = counts.get(i);
            if (number > 1) {
                System.out.println(characters.get(i) + " " + counts.get(i));
            }
        }
    }

    public static void main(String[] args) {
        CharactersInPlay charactersInPlay = new CharactersInPlay();
        charactersInPlay.tester();
    }
}
