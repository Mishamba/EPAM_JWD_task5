package com.mishamba.day5.service.impl;

import com.mishamba.day5.service.RemoveSymbols;
import org.jetbrains.annotations.NotNull;

public class RemoveSymbolsByCharImpl implements RemoveSymbols {
    @Override
    public String removeWordsStartsWithVowelsByLength(@NotNull String text, int length) {
        char[] castedText = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            if (
                    (castedText[i] == 'e') ||
                    (castedText[i] == 'y') ||
                    (castedText[i] == 'u') ||
                    (castedText[i] == 'i') ||
                    (castedText[i] == 'o') ||
                    (castedText[i] == 'a')
            ) {
                int wordIndex = i;
                while (castedText[wordIndex] != ' ') {
                    wordIndex++;
                }

                if (wordIndex == length) {
                    char[] textWithoutSubString = new char
                            [text.length() - length];
                    for (int j = 0; j < i; j++) {
                        textWithoutSubString[j] = text.charAt(j);
                    }
                    for (int j = i; j < textWithoutSubString.length; j++) {
                        textWithoutSubString[j] = text.charAt(j + length);
                    }

                    castedText = textWithoutSubString;
                }
            }
        }

        return new String(castedText);
    }

    @Override
    public String removePunctuation(@NotNull String text) {
        char[] castedText = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            if (
                    (castedText[i] == 'e') ||
                    (castedText[i] == 'y') ||
                    (castedText[i] == 'u') ||
                    (castedText[i] == 'i') ||
                    (castedText[i] == 'o') ||
                    (castedText[i] == 'a')
            ) {
                    char[] textWithoutSubString = new char
                            [text.length() - 1];
                    for (int j = 0; j < i; j++) {
                        textWithoutSubString[j] = text.charAt(j);
                    }
                    for (int j = i; j < textWithoutSubString.length; j++) {
                        textWithoutSubString[j] = text.charAt(j + 1);
                    }

                    castedText = textWithoutSubString;
            }
        }

        return new String(castedText);
    }
}
