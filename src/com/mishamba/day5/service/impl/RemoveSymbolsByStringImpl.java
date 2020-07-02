package com.mishamba.day5.service.impl;

import com.mishamba.day5.service.RemoveSymbols;
import org.jetbrains.annotations.NotNull;

public class RemoveSymbolsByStringImpl implements RemoveSymbols {

    @Override
    public String removePunctuation(@NotNull String text) {
        return text.replaceAll(
                "[!@#$%^&*()_+-=}{\\]\\[\"':;?/>.<,\\\\|`~]", " ");
    }

    @Override
    public String removeWordsStartsWithVowelsByLength(@NotNull String text,
                                                      int length) {
        return text.replaceAll("(?<=\\b)\\w{" + length + "}(?!\\w)", " ");
    }
}
