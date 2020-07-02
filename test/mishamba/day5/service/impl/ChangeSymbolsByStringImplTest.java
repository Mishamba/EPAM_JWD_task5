package mishamba.day5.service.impl;

import com.mishamba.day5.exception.ProgramException;
import com.mishamba.day5.reader.ReadProcessor;
import com.mishamba.day5.service.impl.ChangeSymbolsByRegExImpl;
import com.mishamba.day5.service.impl.ChangeSymbolsByStringImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.*;

public class ChangeSymbolsByStringImplTest {
    private String sourceText;
    private String expectedChangeWordWithSubStringText;
    private String expectedCorrectWrongLetterText;
    private String expectedEvery5LetterChangeText;

    @BeforeTest
    public void readTexts() throws ProgramException {
        ReadProcessor reader = new ReadProcessor();
        Path sourceText = Paths.get("source_texts/text");
        this.sourceText = reader.readLines(sourceText).get(0);
        Path changeWordWithSubStringPath = Paths.
                get("test_texts/forChangeWordWithSubString");
        this.expectedChangeWordWithSubStringText = reader.
                readLines(changeWordWithSubStringPath).get(0);
        Path correctWrongLetterPath = Paths.
                get("test_texts/forCorrectWrongLetter");
        this.expectedCorrectWrongLetterText = reader.
                readLines(correctWrongLetterPath).get(0);
        Path every5LetterChangePath = Paths.
                get("test_texts/forEvery5LetterChange");
        this.expectedEvery5LetterChangeText = reader.
                readLines(every5LetterChangePath).get(0);
    }

    @Test
    public void testChangeEveryKLetter() {
        ChangeSymbolsByStringImpl service = new ChangeSymbolsByStringImpl();
        String actualText = service.changeEveryKLetter(sourceText, 5, "H");
        assertEquals(actualText, expectedEvery5LetterChangeText);
    }

    @Test
    public void testCorrectWrongLetter() {
        ChangeSymbolsByStringImpl service = new ChangeSymbolsByStringImpl();
        String actualText = service.correctWrongLetter(sourceText, "no", "nH");
        assertEquals(actualText, expectedCorrectWrongLetterText);
    }

    @Test
    public void testChangeWordsSelectedByLength() {
        ChangeSymbolsByStringImpl service = new ChangeSymbolsByStringImpl();
        String actualText = service.changeWordsSelectedByLength(
                sourceText,
                3,
                "HHH");
        assertEquals(actualText, expectedChangeWordWithSubStringText);
    }
}