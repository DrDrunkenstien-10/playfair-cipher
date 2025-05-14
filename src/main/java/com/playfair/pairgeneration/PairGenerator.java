package com.playfair.pairgeneration;

import java.util.ArrayList;
import java.util.List;

public class PairGenerator {
    // Function to generate pairs from the given input
    public static List<String> generatePairs(String plainText) {
        List<String> pairs = new ArrayList<>();

        for (int i = 0; i < plainText.length(); i += 2) {
            String pair = plainText.substring(i, i + 2);
            pairs.add(pair);
        }

        return pairs;
    }
}
