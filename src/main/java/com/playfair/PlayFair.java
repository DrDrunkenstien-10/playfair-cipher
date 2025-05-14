package com.playfair;

import java.util.Scanner;

import com.playfair.decryption.Decryption;
import com.playfair.encryption.Encryption;

public class PlayFair {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the encryption key:");
        String key = scanner.nextLine();

        System.out.println("Enter the plain text:");
        String plainText = scanner.nextLine();

        String cipherText = Encryption.encrypt(key, plainText);
        System.out.println("Cipher Text: " + cipherText);

        String decryptedPlainText = Decryption.decrypt(key, cipherText);
        System.out.println("Decrypted Plain Text: " + decryptedPlainText);

        scanner.close();
    }
}