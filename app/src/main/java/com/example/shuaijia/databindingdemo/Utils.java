package com.example.shuaijia.databindingdemo;

public class Utils {

    public static String displayPassowrdText(String s) {
        if (s == null)
            return "";
        int sl = s.length();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < sl; i++) {
            buffer.append("*");
        }

        return buffer.toString();
    }
}
