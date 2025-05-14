package com.playfair.keymatrixgeneration;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class KeyMatrixGenerator {
    private static final int ROWS = 5;
    private static final int COLUMNS = 5;
    private static final int MATRIX_SIZE = 26;

    // Function to generate the key matrix from the given key
    public static char[][] generateKeyMatrix(String key) {
        String upperCaseKey = key.toUpperCase();

        LinkedHashSet<Character> uniqueCharacters = removeDuplicates(upperCaseKey);

        uniqueCharacters = generateKeyMatrixCharacters(uniqueCharacters);

        char[][] keyMatrix = populateKeyMatrix(uniqueCharacters);

        return keyMatrix;
    }

    // Function to store the unique characters of the given key in a LinkedHashSet.
    // LinkedHashSet will ensure it contains unique characters and also it will
    // maintian the order
    private static LinkedHashSet<Character> removeDuplicates(String key) {
        LinkedHashSet<Character> uniqueCharacters = new LinkedHashSet<>();

        for (int i = 0; i < key.length(); i++) {
            uniqueCharacters.add(key.charAt(i));
        }

        return uniqueCharacters;
    }

    // Function to store unique characters from the gievn key as well as the other
    // remaining characters from the alphabets (excluding J) in the LinkedHashSet
    private static LinkedHashSet<Character> generateKeyMatrixCharacters(LinkedHashSet<Character> uniqueCharacters) {
        for (int i = 0; i < MATRIX_SIZE; i++) {
            char character = (char) ('A' + i);

            if (character == 'J') {
                continue;
            }

            uniqueCharacters.add(character);
        }

        return uniqueCharacters;
    }

    // Function to populate the 5 X 5 key matrix
    private static char[][] populateKeyMatrix(LinkedHashSet<Character> uniqueCharacters) {
        char[][] keyMatrix = new char[ROWS][COLUMNS];

        Iterator<Character> iterator = uniqueCharacters.iterator();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (iterator.hasNext()) {
                    keyMatrix[i][j] = iterator.next();
                }
            }
        }

        return keyMatrix;
    }
}
