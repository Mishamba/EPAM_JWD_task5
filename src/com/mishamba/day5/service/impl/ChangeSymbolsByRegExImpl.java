package com.mishamba.day5.service.impl;

import com.mishamba.day5.service.ChangeSymbols;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeSymbolsByRegExImpl implements ChangeSymbols {

    @Override
    public String changeEveryKLetter(@NotNull String text, int k,
                                     @NotNull String symbol) {
        Pattern pattern = Pattern.compile("(?<=\\b\\w{" + (k - 1) + "})[\\w]");
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
        Pattern pattern = Pattern.compile
                ("(?<=\\b)\\w{" + length + "}(?!\\w)");
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(subString);
    }
}
