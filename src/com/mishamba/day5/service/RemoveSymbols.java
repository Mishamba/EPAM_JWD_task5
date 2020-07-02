package com.mishamba.day5.service;

public interface RemoveSymbols {
    String removePunctuation(String text);
    String removeWordsStartsWithVowelsByLength(String text, int length);
}
