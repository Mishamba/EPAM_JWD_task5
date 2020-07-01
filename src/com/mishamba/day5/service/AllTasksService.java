package com.mishamba.day5.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllTasksService {
    public String changeEveryKLetterByRegEx(String text, int k, String symbol) {
        Pattern pattern = Pattern.compile("(?<=\\s\\w{" + (k - 1) + "})\\w");
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(symbol);
    }

    public String correctWrongLetterByRegEx(String text, String afterSymbols,
                                     String newLetter) {
        Pattern pattern = Pattern.compile(afterSymbols);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(afterSymbols.substring(0, 1) + newLetter);
    }

    public String changeWordsSelectedByLengthByRegEx(String text, int length, String subString) {
        Pattern pattern = Pattern.compile("(?<=\\s)\\w{" + length + "}(?!\\w)");
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(subString);
    }

    public String removePunctuation(String text) {
        Pattern pattern = Pattern.compile("[!@#$%^&*()_+-=}{\\]\\[\"':;?/>.<,\\\\|`~]");
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(" ");
    }

    public String removeWordsStartsWithVowelsByLength(String text, int length) {
        Pattern pattern = Pattern.compile("(?<=\\s)[eyuioa]\\w{" + (length - 1) + ")}(?!\\w)");
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll("");
    }
}
