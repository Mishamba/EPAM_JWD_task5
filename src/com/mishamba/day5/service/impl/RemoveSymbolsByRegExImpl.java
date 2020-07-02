package com.mishamba.day5.service.impl;

import com.mishamba.day5.service.RemoveSymbols;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveSymbolsByRegExImpl implements RemoveSymbols {

    @Override
    public String removePunctuation(String text) {
        Pattern pattern = Pattern.compile
                ("[!@#$%^&*()_+-=}{\\]\\[\"':;?/>.<,\\\\|`~]");
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(" ");
    }

    @Override
    public String removeWordsStartsWithVowelsByLength(String text,
                                                      int length) {
        Pattern pattern = Pattern.compile
                ("(?<=\\s)[eyuioa]\\w{" + (length - 1) + ")}(?!\\w)");
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll("");
    }
}
