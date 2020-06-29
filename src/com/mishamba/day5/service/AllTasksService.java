package com.mishamba.day5.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllTasksService {
    public String changeEveryKLetterByRegEx(String input, int k, String symbol) {
        Pattern pattern = Pattern.compile("\\S{" + k + "}");
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll(symbol);
    }

    public String correctWrongLetterByRegEx(String input, String afterSymbol,
                                     String newLetter) {
        Pattern pattern = Pattern.compile(afterSymbol + "\\S");
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll(afterSymbol + newLetter);
    }

    public String changeWordsSelectedByLengthByRegEx(String text, int length, String subString) {
        Pattern pattern = Pattern.compile("\\S{" + length + "}");
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(subString);
    }
}
