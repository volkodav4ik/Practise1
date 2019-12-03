package com.volkodav4ik;

import java.util.Random;

public class Practise3 {

    private static Random RANDOM = new Random();
    private static int PASS_LENGTH = 8;
    private static int LETTERS = 3;
    private static int NUMBERS = 2;
    private static int LETTER_IN_ALPHABET = 26;
    private static int TO_SMALL_LETTER = 97;
    private static int TO_BIG_LETTER = 65;
    private static int TO_FIGURES = 48;
    private static int FIGURES = 10;

    public static void main(String[] args) {
        StringBuilder password = new StringBuilder("");
        createPass(password);
        String s = password.toString();
        char[] arr = mashPass(s);
        System.out.println("Your new generated password: " + printPass(arr));
    }

    private static String printPass(char[] arr) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    private static char[] mashPass(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < PASS_LENGTH; i++) {
            int j = RANDOM.nextInt(PASS_LENGTH);
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        boolean b = RANDOM.nextBoolean();
        if (b == true) {
            int i = RANDOM.nextInt(PASS_LENGTH);
            arr[i] = '_';
        }
        return arr;
    }

    private static void createPass(StringBuilder password) {
        for (int i = 1; i <= LETTERS; i++) {
            char code = (char) ((char) RANDOM.nextInt(LETTER_IN_ALPHABET) + TO_SMALL_LETTER);
            password.append(code);
        }
        for (int i = 1; i <= LETTERS; i++) {
            char code = (char) ((char) RANDOM.nextInt(LETTER_IN_ALPHABET) + TO_BIG_LETTER);
            password.append(code);
        }
        for (int i = 1; i <= NUMBERS; i++) {
            char code = (char) ((char) RANDOM.nextInt(FIGURES) + TO_FIGURES);
            password.append(code);
        }
    }
}
