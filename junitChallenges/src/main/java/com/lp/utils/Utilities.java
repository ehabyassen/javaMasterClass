package com.lp.utils;

public class Utilities {

    public char[] everyNthChar(char[] sourceArray, int n) {
        if (sourceArray == null || sourceArray.length < n) return sourceArray;
        char[] result = new char[sourceArray.length / n];
        int index = 0;
        for (int i = n - 1; i < sourceArray.length; i += n) {
            result[index++] = sourceArray[i];
        }
        return result;
    }

    public String removePairs(String source) {
        if (source == null || source.length() < 2) return source;
        StringBuilder sb = new StringBuilder();
        sb.append(source.charAt(0));
        for (int i = 1; i < source.length(); i++) {
            if (source.charAt(i - 1) != source.charAt(i)) {
                sb.append(source.charAt(i));
            }
        }
        return sb.toString();
    }

    public int converter(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("b can not be 0 because the formula includes division by b");
        return (a / b) + (a * 30) - 2;
    }

    public String nullIfOddLength(String source) {
        if (source == null) return null;
        return (source.length() % 2 == 0) ? source : null;
    }
}
