package com.mishamba.day5.service.impl;

import com.mishamba.day5.service.ChangeSymbols;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeSymbolsByRegExImpl implements ChangeSymbols {
    private final String EVERY_K_LETTER = "(?<=\\b\\w{%d})[\\w]";
    private final String WORD_WITH_LENGTH = "(?<=\\b)\\w{%d}(?!\\w)";

    @Override
    public String changeEveryKLetter(@NotNull String text, int k,
                                     @NotNull String symbol) {
        String regEx = String.format(EVERY_K_LETTER, k - 1);
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(symbol);
    }

    @Override
    public String correctWrongLetter(@NotNull String text,
                                     @NotNull String incorrectPair,
                                     @NotNull String correctPair) {
        Pattern pattern = Pattern.compile(incorrectPair);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(correctPair);
    }

    @Override
    public String changeWordsSelectedByLength(@NotNull String text, int length,
                                              @NotNull String subString) {
        String regEx = String.format(WORD_WITH_LENGTH, length);
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(subString);
    }
}
