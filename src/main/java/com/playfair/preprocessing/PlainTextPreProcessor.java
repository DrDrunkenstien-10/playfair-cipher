package com.playfair.preprocessing;

public class PlainTextPreProcessor {
    // Preprocess the plain text
    public static String preProcessPlainText(String plainText) {
        String updatedPlainText = removeSpacesAndConvertToUpperCase(plainText);

        StringBuilder stringBuilder = new StringBuilder(updatedPlainText);

        // Insert 'X' between characters that appears consecutively
        for (int i = 0; i < (stringBuilder.length() - 1); i++) {
            if (stringBuilder.charAt(i) == stringBuilder.charAt(i + 1)) {
                stringBuilder.insert(i + 1, 'X');
                i++;
            }
        }

        // Ensure the updated plain text even in size
        if (stringBuilder.length() % 2 != 0) {
            stringBuilder.append('X');
        }

        return stringBuilder.toString();
    }

    // Function to remove spaces from the given plain text and then convert it to
    // upper case
    private static String removeSpacesAndConvertToUpperCase(String plainText) {
        return plainText.replace(" ", "").toUpperCase();
    }
}
