package com.playfair.encryption;

import java.util.List;

import com.playfair.keymatrixgeneration.KeyMatrixGenerator;
import com.playfair.pairgeneration.PairGenerator;
import com.playfair.preprocessing.PlainTextPreProcessor;

public class Encryption {
    private static final int ROWS = 5;
    private static final int COLUMNS = 5;

    public static String encrypt(String key, String plainText) {
        StringBuilder cipherText = new StringBuilder();

        char[][] keyMatrix = KeyMatrixGenerator.generateKeyMatrix(key);

        String preProcessedPlainText = PlainTextPreProcessor.preProcessPlainText(plainText);

        List<String> pairs = PairGenerator.generatePairs(preProcessedPlainText);

        for (int i = 0; i < pairs.size(); i++) {
            String pair = pairs.get(i);

            char firstCharacter = 'J';
            char secondCharacter = 'J';

            int firstCharacterRow = -1;
            int firstCharacterColumn = -1;

            int secondCharacterRow = -1;
            int secondCharacterColumn = -1;

            for (int j = 0; j < (pair.length() - 1); j++) {
                firstCharacter = pair.charAt(0);
                secondCharacter = pair.charAt(1);
            }

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
                cipherText.append(encryptUsingRuleTwo(firstCharacterRow, secondCharacterRow, firstCharacterColumn,
                        secondCharacterColumn, keyMatrix));
            }

            else if (firstCharacterColumn == secondCharacterColumn) {
                cipherText.append(encryptUsingRuleThree(firstCharacterRow,
                        secondCharacterRow, firstCharacterColumn,
                        secondCharacterColumn, keyMatrix));
            }

            else {
                cipherText.append(encryptUsingRuleOne(firstCharacterRow, secondCharacterRow, firstCharacterColumn,
                        secondCharacterColumn, keyMatrix));
            }
        }

        return cipherText.toString();
    }

    private static String encryptUsingRuleOne(int firstCharacterRow, int secondCharacterRow,
            int firstCharacterColumn, int secondCharacterColumn, char[][] keyMatrix) {
        String cipherText = "";

        cipherText = cipherText + (keyMatrix[firstCharacterRow][secondCharacterColumn]);
        cipherText = cipherText + (keyMatrix[secondCharacterRow][firstCharacterColumn]);

        return cipherText;
    }

    private static String encryptUsingRuleTwo(int firstCharacterRow, int secondCharacterRow,
            int firstCharacterColumn, int secondCharacterColumn, char[][] keyMatrix) {
        String cipherText = "";

        cipherText = cipherText + (keyMatrix[firstCharacterRow][(firstCharacterColumn + 1) % 5]);
        cipherText = cipherText + (keyMatrix[firstCharacterRow][(secondCharacterColumn + 1) % 5]);

        return cipherText;
    }

    private static String encryptUsingRuleThree(int firstCharacterRow, int secondCharacterRow,
            int firstCharacterColumn, int secondCharacterColumn, char[][] keyMatrix) {
        String cipherText = "";

        cipherText = cipherText + (keyMatrix[(firstCharacterRow + 1) % 5][firstCharacterColumn]);
        cipherText = cipherText + (keyMatrix[(secondCharacterRow + 1) % 5][firstCharacterColumn]);

        return cipherText;
    }
}
