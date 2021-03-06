package mishamba.day5.service.impl;

import com.mishamba.day5.exception.ProgramException;
import com.mishamba.day5.reader.ReadProcessor;
import com.mishamba.day5.service.impl.ChangeSymbolsByCharImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.*;

public class ChangeSymbolsByCharImplTest {
    private String sourceText;
    private String resultChangeWordWithSubStringText;
    private String resultCorrectWrongLetterText;
    private String resultEvery5LetterChangeText;

    @BeforeTest
    public void readTexts() throws ProgramException {
        ReadProcessor reader = new ReadProcessor();
        Path sourceText = Paths.get("source_texts/text");
        this.sourceText = reader.readLines(sourceText).get(0);
        Path changeWordWithSubStringPath = Paths.
                get("test_texts/forChangeWordWithSubString");
        this.resultChangeWordWithSubStringText = reader.
                readLines(changeWordWithSubStringPath).get(0);
        Path correctWrongLetterPath = Paths.
                get("test_texts/forCorrectWrongLetter");
        this.resultCorrectWrongLetterText = reader.
                readLines(correctWrongLetterPath).get(0);
        Path every5LetterChangePath = Paths.
                get("test_texts/forEvery5LetterChange");
        this.resultEvery5LetterChangeText = reader.
                readLines(every5LetterChangePath).get(0);
    }

    @Test
    public void testChangeEveryKLetter() {
        ChangeSymbolsByCharImpl service = new ChangeSymbolsByCharImpl();
        String actualText = service.changeEveryKLetter(sourceText, 5, "H");
        assertEquals(actualText, resultEvery5LetterChangeText);
    }

    @Test
    public void testChangeWordsSelectedByLength() {
        ChangeSymbolsByCharImpl service = new ChangeSymbolsByCharImpl();
        String actualText = service.changeWordsSelectedByLength(sourceText, 3, "HHH");
        assertEquals(actualText, resultChangeWordWithSubStringText);
    }

    @Test
    public void testCorrectWrongLetter() {
        ChangeSymbolsByCharImpl service = new ChangeSymbolsByCharImpl();
        String actualText = service.correctWrongLetter(
                sourceText,
                "no",
                "nH");
        assertEquals(actualText, resultCorrectWrongLetterText);
    }
}