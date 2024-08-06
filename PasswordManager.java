package org.example;

import java.util.*;

public class PasswordManager {
    // create a global string class that holds the password
    private static StringBuilder password = new StringBuilder();

    // randomly generate 4 numbers (0-9), convert to string then append to string
    public static void generate() {
        password.setLength(0); // reset the password string to 0 for accuracy
        Random random = new Random();

        // Generates 4 random letters and appends them to the global variable
        for (int i = 0; i < 4; i++) {
            int randomNumber = random.nextInt(10);
            password.append(randomNumber);
        }
        randomUppercaseLetters(); // To add the uppercase letters to the global variable
        randomSymbols(); // To add the symbols to the global variable
        shufflePassword(); // To shuffle the contents of the global variable
    }

    // Generate 2 uppercase characters then append to the global variable
    private static void randomUppercaseLetters() {
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            // Generates an ascii character starting from 'A' which is 65 + from 0 to 25 randomly
            char randomLetter = (char) ('A' + random.nextInt(26));
            password.append(randomLetter);
        }
    }

    // randomly generate 2 symbols (_ $ # %), convert to string then append to string
    private static void randomSymbols() {
        Random random = new Random();
        char[] symbols = {'_', '$', '#', '%'};
        // Iterates through the symbols list twice and appends them to the global variable
        for (int i = 0; i < 2; i++) {
            char randomSymbol = symbols[random.nextInt(symbols.length)];
            password.append(randomSymbol);
        }
    }

    // shuffle the contents of the password
    private static void shufflePassword() {
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < password.length(); i++) {
            // Adds the String password and makes it a list separating each character
            characters.add(password.charAt(i));
        }
        // Shuffles the characters list
        Collections.shuffle(characters);

        // Clear out the password String in order to append the shuffled characters
        password.setLength(0);
        for (char c : characters) {
            password.append(c);
        }
    }

    public static String getPassword() {
        return password.toString();
    }
}