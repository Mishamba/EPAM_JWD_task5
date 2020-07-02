package mishamba.day5.service.impl;

import com.mishamba.day5.exception.ProgramException;
import com.mishamba.day5.reader.ReadProcessor;
import com.mishamba.day5.service.RemoveSymbols;
import com.mishamba.day5.service.impl.RemoveSymbolsByRegExImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.*;

public class RemoveSymbolsByRegExImplTest {
    private String sourceText;
    private String resultPunctuationRemovingText;
    private String resultRemoveWordsStartsWithVowelsByLength;

    @BeforeTest
    public void readTexts() throws ProgramException {
        ReadProcessor reader = new ReadProcessor();
        Path sourceText = Paths.get("source_texts/text");
        this.sourceText = reader.readLines(sourceText).get(0);
        Path punctuationRemovingPath = Paths.
                get("test_texts/forPunctuationRemoving");
        this.resultPunctuationRemovingText = reader.
                readLines(punctuationRemovingPath).get(0);
        Path removeWordsStartsWithVowelsByPath = Paths.
                get("test_texts/forRemovingWords");
        this.resultRemoveWordsStartsWithVowelsByLength = reader.
                readLines(removeWordsStartsWithVowelsByPath).get(0);
    }

    @Test
    public void testRemovePunctuation() { // TODO: 7/2/20  
        RemoveSymbolsByRegExImpl service = new RemoveSymbolsByRegExImpl();
        String actualText = service.removePunctuation(sourceText);
        assertEquals(actualText, resultPunctuationRemovingText);
    }

    @Test
    public void testRemoveWordsStartsWithVowelsByLength() {
        RemoveSymbolsByRegExImpl service = new RemoveSymbolsByRegExImpl();
        String actualText = service.
                removeWordsStartsWithVowelsByLength(sourceText, 4);
        assertEquals(actualText, resultRemoveWordsStartsWithVowelsByLength);
    }
}