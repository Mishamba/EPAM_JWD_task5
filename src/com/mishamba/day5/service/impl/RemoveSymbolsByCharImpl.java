package com.mishamba.day5.service.impl;

import com.mishamba.day5.service.RemoveSymbols;
import org.jetbrains.annotations.NotNull;

public class RemoveSymbolsByCharImpl implements RemoveSymbols {
    @Override
    public String removeWordsStartsWithVowelsByLength(@NotNull String text, int length) {
        /*char[] castedText = text.toCharArray();
        int begin = 0;
        for (int i = 0; i < castedText.length; i++) {
            if (
                    (castedText[i] == 'e') ||
                    (castedText[i] == 'y') ||
                    (castedText[i] == 'u') ||
                    (castedText[i] == 'i') ||
                    (castedText[i] == 'o') ||
                    (castedText[i] == 'a')
            ) {
                int wordIndex = i;
                int wordLength = 0;
                while (castedText[wordIndex] != ' ') {
                    wordLength++;
                    wordIndex++;
                }

                if (wordLength == length) {
                    char[] textWithoutSubString = new char
                            [text.length() - length];
                    System.arraycopy(castedText, 0, textWithoutSubString, 0, i);
                    for (int j = i; j < textWithoutSubString.length; j++) {
                        textWithoutSubString[j] = text.charAt(j + length);
                    }

                    castedText = textWithoutSubString;
                }
            }
        }

        return new String(castedText);*/
        char[] castedText = text.toCharArray();
        int begin = 0;
        for (int i = 0; i < castedText.length; i++) {
            if ((castedText[i] == ' ') ||
                    (castedText[i] == ',') ||
                    (castedText[i] == '.') ||
                    (castedText[i] == '!')) {
                begin = i + 1;
            }

            if ((i - begin == length - 1) && (
                    (castedText[i + 1] == ' ') ||
                    (castedText[i + 1] == ',') ||
                    (castedText[i + 1] == '.') ||
                    (castedText[i + 1] == '!')) &&
                    ((castedText[begin] == 'e') ||
                    (castedText[begin] == 'y') ||
                    (castedText[begin] == 'u') ||
                    (castedText[begin] == 'i') ||
                    (castedText[begin] == 'o') ||
                    (castedText[begin] == 'a'))) {
                char[] textWithSubString = new char
                        [castedText.length - length];
                System.arraycopy(castedText, 0, textWithSubString, 0, begin);
                for (int j = begin;
                     j < text.length() - length;
                     j++) {
                    textWithSubString[j] = text.
                            charAt(j + length);
                }

                castedText = textWithSubString;
            }
        }

        return new String(castedText);
    }

    @Override
    public String removePunctuation(@NotNull String text) {
        char[] castedText = text.toCharArray();
        for (int i = 0; i < castedText.length; i++) {
            if (
                    (castedText[i] == '!') ||
                    (castedText[i] == '@') ||
                    (castedText[i] == '#') ||
                    (castedText[i] == '\'') ||
                    (castedText[i] == '\"') ||
                    (castedText[i] == '^') ||
                    (castedText[i] == '?') ||
                    (castedText[i] == '*') ||
                    (castedText[i] == '(') ||
                    (castedText[i] == ')') ||
                    (castedText[i] == '-') ||
                    (castedText[i] == '_') ||
                    (castedText[i] == '=') ||
                    (castedText[i] == '\\') ||
                    (castedText[i] == '|') ||
                    (castedText[i] == ']') ||
                    (castedText[i] == ',') ||
                    (castedText[i] == '.') ||
                    (castedText[i] == ';') ||
                    (castedText[i] == ':')
            ) {
                char[] textWithoutSubString = new char[text.length() - 1];
                System.arraycopy(castedText, 0,
                        textWithoutSubString, 0, i);
                if (textWithoutSubString.length - i >= 0) {
                    System.arraycopy(
                            castedText, i + 1,
                            textWithoutSubString, i,
                            castedText.length - i - 1);
                }

                castedText = textWithoutSubString;
            }
        }

        return new String(castedText).replaceAll("\\p{Cntrl}", "");
    }
}
