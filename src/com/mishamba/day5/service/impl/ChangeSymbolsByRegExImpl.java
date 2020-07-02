package com.mishamba.day5.service.impl;

import com.mishamba.day5.service.ChangeSymbols;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeSymbolsByRegExImpl implements ChangeSymbols {

    @Override
    public String changeEveryKLetter(String text, int k, String symbol) {
        Pattern pattern = Pattern.compile("(?<=\\b[\\w{" + (k - 1) + "}])[\\w]");
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(symbol);
    }

    @Override
    public String correctWrongLetter(String text, String incorrectPair,
                                     String correctPair) {
        Pattern pattern = Pattern.compile(incorrectPair);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(correctPair);
    }

    @Override
    public String changeWordsSelectedByLength(String text, int length,
                                              String subString) {
        Pattern pattern = Pattern.compile
                ("(?<=\\s)\\w{" + length + "}(?!\\w)");
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(subString);
    }
}
