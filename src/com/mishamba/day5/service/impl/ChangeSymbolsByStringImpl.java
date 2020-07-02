package com.mishamba.day5.service.impl;

import com.mishamba.day5.service.ChangeSymbols;
import org.jetbrains.annotations.NotNull;

public class ChangeSymbolsByStringImpl implements ChangeSymbols {
    private final String EVERY_K_LETTER = "(?<=\\b\\w{%d})[\\w]";
    private final String WORD_WITH_LENGTH = "(?<=\\b)\\w{%d}(?!\\w)";

    @Override
    public String changeEveryKLetter(@NotNull String text, int k, String symbol) {
        String regEx = String.format(EVERY_K_LETTER, k - 1);
        return text.replaceAll(
                regEx,
                symbol);
    }

    @Override
    public String correctWrongLetter(@NotNull String text,
                                     @NotNull String incorrectPair,
                                     @NotNull String correctPair) {
        return text.replaceAll(incorrectPair, correctPair);
    }

    @Override
    public String changeWordsSelectedByLength(@NotNull String text, int length,
                                              @NotNull String subString) {
        String regEx = String.format(WORD_WITH_LENGTH, length);
        return text.replaceAll(
                    regEx,
                    subString);
    }
}
