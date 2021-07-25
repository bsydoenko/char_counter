package ua.com.foxminded.charcounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CharCounterTest 
{
	
	public static final String NEWLINE = System.lineSeparator();
	private CharCounter charCounter = new CharCounter();
	
	@Test
	void givenNull_whenCharCounter_thenIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> charCounter.countChar(null));
	}
	
	Map<Character, Integer> expectedResultForEmptyText = new LinkedHashMap<>();
	
	@Test
	void givenEmptyText_whenCharCounter_thenEmptyText() {
		assertEquals(expectedResultForEmptyText, charCounter.countChar(""));
	}
	
	Map<Character, Integer> expectedResulForWord = new LinkedHashMap<>();{
		expectedResulForWord.put('f', 1);
		expectedResulForWord.put('o', 1);
		expectedResulForWord.put('x', 1);
		expectedResulForWord.put('m', 1);
		expectedResulForWord.put('i', 1);
		expectedResulForWord.put('n', 1);
		expectedResulForWord.put('d', 2);
		expectedResulForWord.put('e', 1);
	}
	
	@Test
	void givenWord_whenCharCounter_thenResult() {
		assertEquals(expectedResulForWord, charCounter.countChar("foxminded"));
	}
	
	Map<Character, Integer> expectedResulForWordWithSymbols = new LinkedHashMap<>();{
		expectedResulForWordWithSymbols.put('@', 1);
		expectedResulForWordWithSymbols.put('7', 3);
		expectedResulForWordWithSymbols.put('f', 1);
		expectedResulForWordWithSymbols.put('o', 1);
		expectedResulForWordWithSymbols.put('x', 1);
		expectedResulForWordWithSymbols.put('m', 1);
		expectedResulForWordWithSymbols.put('i', 1);
		expectedResulForWordWithSymbols.put('n', 1);
		expectedResulForWordWithSymbols.put('d', 2);
		expectedResulForWordWithSymbols.put('e', 1);
		expectedResulForWordWithSymbols.put('!', 3);
	}
	
	@Test
	void givenWordWithSymbols_whenCharCounter_thenResult() {
		assertEquals(expectedResulForWordWithSymbols, charCounter.countChar("@777foxminded!!!"));
	}
	
	Map<Character, Integer> expectedResulForNonLetterWord = new LinkedHashMap<>();{
		expectedResulForNonLetterWord.put('@', 1);
		expectedResulForNonLetterWord.put('#', 4);
		expectedResulForNonLetterWord.put('$', 2);
		expectedResulForNonLetterWord.put('^', 1);
		expectedResulForNonLetterWord.put('&', 2);
		expectedResulForNonLetterWord.put('*', 2);
		expectedResulForNonLetterWord.put('(', 2);
		}
	
	@Test
	void givenNonLetterWord_whenCharCounter_thenResult() {
		assertEquals(expectedResulForNonLetterWord, charCounter.countChar("@##$^#&*((*#&$"));
	}
	
	Map<Character, Integer> expectedResulForText = new LinkedHashMap<>();{
		expectedResulForText.put('h', 1);
		expectedResulForText.put('e', 1);
		expectedResulForText.put('l', 3);
		expectedResulForText.put('o', 2);
		expectedResulForText.put(' ', 1);
		expectedResulForText.put('w', 1);
		expectedResulForText.put('r', 1);
		expectedResulForText.put('d', 1);
		}
	
	@Test
	void givenText_whenCharCounter_thenResult() {
		assertEquals(expectedResulForText, charCounter.countChar("hello world"));
	}
	
	Map<Character, Integer> expectedResulForTextWithSymbols = new LinkedHashMap<>();{
		expectedResulForTextWithSymbols.put('1', 1);
		expectedResulForTextWithSymbols.put(')', 1);
		expectedResulForTextWithSymbols.put('*', 2);
		expectedResulForTextWithSymbols.put('h', 1);
		expectedResulForTextWithSymbols.put('e', 1);
		expectedResulForTextWithSymbols.put('l', 3);
		expectedResulForTextWithSymbols.put('o', 2);
		expectedResulForTextWithSymbols.put(' ', 1);
		expectedResulForTextWithSymbols.put('w', 1);
		expectedResulForTextWithSymbols.put('r', 1);
		expectedResulForTextWithSymbols.put('d', 1);
		expectedResulForTextWithSymbols.put('!', 3);
		}
	
	@Test
	void givenTextWithSymbols_whenCharCounter_thenResult() {
		assertEquals(expectedResulForTextWithSymbols, charCounter.countChar("1)**hello world!!!"));
	}
	
	Map<Character, Integer> expectedResulForTextOfNonLetters = new LinkedHashMap<>();{
		expectedResulForTextOfNonLetters.put('4', 1);
		expectedResulForTextOfNonLetters.put('3', 2);
		expectedResulForTextOfNonLetters.put('$', 2);
		expectedResulForTextOfNonLetters.put('%', 3);
		expectedResulForTextOfNonLetters.put('^', 3);
		expectedResulForTextOfNonLetters.put('&', 3);
		expectedResulForTextOfNonLetters.put('*', 2);
		expectedResulForTextOfNonLetters.put(' ', 2);
		expectedResulForTextOfNonLetters.put(')', 1);
		expectedResulForTextOfNonLetters.put('(', 1);
		}
	
	@Test
	void givenTextOfNonLetters_whenCharCounter_thenEmptyText() {
		assertEquals(expectedResulForTextOfNonLetters, charCounter.countChar("43$%^&* )(*&^% $%^&3"));
	}
}
