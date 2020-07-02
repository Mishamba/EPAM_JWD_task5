package com.mishamba.day5.service.impl;

import com.mishamba.day5.service.RemoveSymbols;
import org.jetbrains.annotations.NotNull;

public class RemoveSymbolsByStringImpl implements RemoveSymbols {

    @Override
    public String removePunctuation(@NotNull String text) {
        String processingText = text.replaceAll(
                "\\w\\p{Punct}\\w", " ");
        return processingText.replaceAll("\\p{Punct}", "");
    }

    @Override
    public String removeWordsStartsWithVowelsByLength(@NotNull String text,
                                                      int length) {
        return text.replaceAll("(?<=\\b)[eyuioa]\\w{" + (length - 1) + "}(?!\\w)", "");
    }
}
