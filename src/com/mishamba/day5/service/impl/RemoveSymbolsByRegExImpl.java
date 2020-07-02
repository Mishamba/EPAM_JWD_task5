package com.mishamba.day5.service.impl;

import com.mishamba.day5.service.RemoveSymbols;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveSymbolsByRegExImpl implements RemoveSymbols {

    @Override
    public String removePunctuation(@NotNull String text) {
        Pattern patternBetweenWords = Pattern.compile
                ("\\w\\p{Punct}\\w");
        Matcher matcherBetweenWords = patternBetweenWords.matcher(text);
        String processingText = matcherBetweenWords.replaceAll(" ");
        Pattern patternClearPunctuation = Pattern.compile("\\p{Punct}");
        Matcher matcherCrearPunctuation = patternClearPunctuation.
                matcher(processingText);
        return matcherCrearPunctuation.replaceAll("");
    }

    @Override
    public String removeWordsStartsWithVowelsByLength(@NotNull String text,
                                                      int length) {
        Pattern pattern = Pattern.compile
                ("(?<=\\b)[eyuioa]\\w{" + (length - 1) + "}(?!\\w)");
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll("");
    }
}
