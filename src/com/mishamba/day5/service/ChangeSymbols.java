package com.mishamba.day5.service;

public interface ChangeSymbols {
    String changeEveryKLetter(String text, int k, String symbol);
    String correctWrongLetter(String text, String incorrectPair, String correctPair);
    String changeWordsSelectedByLength(String test, int length, String subString);
}
