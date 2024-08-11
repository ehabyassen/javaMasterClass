package com.lp;

public class StringUtilities {

    private StringBuilder sBuilder = new StringBuilder();
    private int chars = 0;

    public void addChar(StringBuilder sBuilder, char c) {
        sBuilder.append(c);
        chars++;
    }

}
