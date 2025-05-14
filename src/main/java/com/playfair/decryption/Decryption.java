package com.playfair.decryption;

import java.util.List;

import com.playfair.keymatrixgeneration.KeyMatrixGenerator;
import com.playfair.pairgeneration.PairGenerator;

public class Decryption {
    private static final int ROWS = 5;
    private static final int COLUMNS = 5;

    public static String decrypt(String key, String cipherText) {
        StringBuilder plainText = new StringBuilder();

        char[][] keyMatrix = KeyMatrixGenerator.generateKeyMatrix(key);

        List<String> pairs = PairGenerator.generatePairs(cipherText);

        for (int i = 0; i < pairs.size(); i++) {
            String pair = pairs.get(i);

            char firstCharacter = pair.charAt(0);
            char secondCharacter = pair.charAt(1);

            int firstCharacterRow = -1;
            int firstCharacterColumn = -1;

            int secondCharacterRow = -1;
            int secondCharacterColumn = -1;

            for (int k = 0; k < ROWS; k++) {
                for (int l = 0; l < COLUMNS; l++) {
                    if (keyMatrix[k][l] == firstCharacter) {
                        firstCharacterRow = k;
                        firstCharacterColumn = l;
                    }

                    else if (keyMatrix[k][l] == secondCharacter) {
                        secondCharacterRow = k;
                        secondCharacterColumn = l;
                    }
                }
            }

            if (firstCharacterRow == secondCharacterRow) {
                plainText.append(encryptUsingRuleTwo(firstCharacterRow, secondCharacterRow, firstCharacterColumn,
                        secondCharacterColumn, keyMatrix));
            }

            else if (firstCharacterColumn == secondCharacterColumn) {
                plainText.append(encryptUsingRuleThree(firstCharacterRow,
                        secondCharacterRow, firstCharacterColumn,
                        secondCharacterColumn, keyMatrix));
            }

            else {
                plainText.append(encryptUsingRuleOne(firstCharacterRow, secondCharacterRow, firstCharacterColumn,
                        secondCharacterColumn, keyMatrix));
            }
        }

        int indexOfX = plainText.indexOf("X");

        plainText.deleteCharAt(indexOfX);

        return plainText.toString();
    }

    private static String encryptUsingRuleOne(int firstCharacterRow, int secondCharacterRow,
            int firstCharacterColumn, int secondCharacterColumn, char[][] keyMatrix) {
        String plainText = "";

        plainText = plainText + (keyMatrix[firstCharacterRow][secondCharacterColumn]);
        plainText = plainText + (keyMatrix[secondCharacterRow][firstCharacterColumn]);

        return plainText;
    }

    private static String encryptUsingRuleTwo(int firstCharacterRow, int secondCharacterRow,
            int firstCharacterColumn, int secondCharacterColumn, char[][] keyMatrix) {
        String plainText = "";

        plainText = plainText + (keyMatrix[firstCharacterRow][(firstCharacterColumn + 4) % 5]);
        plainText = plainText + (keyMatrix[firstCharacterRow][(secondCharacterColumn + 4) % 5]);

        return plainText;
    }

    private static String encryptUsingRuleThree(int firstCharacterRow, int secondCharacterRow,
            int firstCharacterColumn, int secondCharacterColumn, char[][] keyMatrix) {
        String plainText = "";

        plainText = plainText + (keyMatrix[(firstCharacterRow + 4) % 5][firstCharacterColumn]);
        plainText = plainText + (keyMatrix[(secondCharacterRow + 4) % 5][firstCharacterColumn]);
        return plainText;
    }
}
