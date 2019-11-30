package com.volkodav4ik;

public class Practise2 {

    private static final char DIFF = 32;

    public static void main(String[] args) {

        String s = "aAaffAFASf aAFfe asfFWfags";
        System.out.println(editString(s));
    }

    private static String editString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int code = 0;
        for (int i = 0; i < sb.length(); i++) {
            code = sb.charAt(i);
            if (code >= 'A' && code <= 'Z') {
                sb.setCharAt(i, (char) (code + DIFF));
            }
        }
        for (int i = 0; i <sb.length() ; i++) {
            code = sb.charAt(i);
            if (code == DIFF) {
                code = sb.charAt(i+1);
                sb.setCharAt((i + 1), (char) (code - DIFF));
            }
        }
        code = sb.charAt(0);
        sb.setCharAt(0, (char) (code - DIFF));
        return sb.toString();
    }
}
