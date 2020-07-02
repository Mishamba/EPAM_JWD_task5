package com.mishamba.day5.service.impl;

import com.mishamba.day5.service.ChangeSymbols;
import org.jetbrains.annotations.NotNull;

public class ChangeSymbolsByStringImpl implements ChangeSymbols {

    @Override
    public String changeEveryKLetter(@NotNull String text, int k, String symbol) {
        return text.replaceAll(
                "(?<=\\b[\\w{" + (k - 1) + "}])[\\w]",
                symbol);
    }

    @Override
    public String correctWrongLetter(@NotNull String text, String incorrectPair,
                                     @NotNull String correctPair) {
        return text.replaceAll(incorrectPair, correctPair);
    }

    @Override
    public String changeWordsSelectedByLength(@NotNull String text, int length,
                                              String subString) {
        return text.replaceFirst(
                    "(?<=\\s)\\w{" + length + "}(?!\\w)",
                    subString);
    }
}
