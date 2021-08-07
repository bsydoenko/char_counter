package ua.com.foxminded.charcounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UniqueCharacterCounterTest {

	public static final String NEWLINE = System.lineSeparator();
	private UniqueCharacterCounter uniqueCharCounter = new UniqueCharacterCounter();

	@Test
	void givenNull_whenCharCounter_thenIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> uniqueCharCounter.countChars(null));
	}

	@Test
	void givenEmptyText_whenCharCounter_thenEmptyText() {
		Map<Character, Integer> expected = new LinkedHashMap<>();

		assertEquals(expected, uniqueCharCounter.countChars(""));
	}

	@Test
	void givenWord_whenCharCounter_thenResult() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('f', 1);
		expected.put('o', 1);
		expected.put('x', 1);
		expected.put('m', 1);
		expected.put('i', 1);
		expected.put('n', 1);
		expected.put('d', 2);
		expected.put('e', 1);

		assertEquals(expected, uniqueCharCounter.countChars("foxminded"));
	}

	@Test
	void givenWordWithSymbols_whenCharCounter_thenResult() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('@', 1);
		expected.put('7', 3);
		expected.put('f', 1);
		expected.put('o', 1);
		expected.put('x', 1);
		expected.put('m', 1);
		expected.put('i', 1);
		expected.put('n', 1);
		expected.put('d', 2);
		expected.put('e', 1);
		expected.put('!', 3);

		assertEquals(expected, uniqueCharCounter.countChars("@777foxminded!!!"));
	}

	@Test
	void givenNonLetterWord_whenCharCounter_thenResult() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('@', 1);
		expected.put('#', 4);
		expected.put('$', 2);
		expected.put('^', 1);
		expected.put('&', 2);
		expected.put('*', 2);
		expected.put('(', 2);

		assertEquals(expected, uniqueCharCounter.countChars("@##$^#&*((*#&$"));
	}

	@Test
	void givenText_whenCharCounter_thenResult() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('h', 1);
		expected.put('e', 1);
		expected.put('l', 3);
		expected.put('o', 2);
		expected.put(' ', 1);
		expected.put('w', 1);
		expected.put('r', 1);
		expected.put('d', 1);

		assertEquals(expected, uniqueCharCounter.countChars("hello world"));
	}

	@Test
	void givenTextWithSymbols_whenCharCounter_thenResult() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('1', 1);
		expected.put(')', 1);
		expected.put('*', 2);
		expected.put('h', 1);
		expected.put('e', 1);
		expected.put('l', 3);
		expected.put('o', 2);
		expected.put(' ', 1);
		expected.put('w', 1);
		expected.put('r', 1);
		expected.put('d', 1);
		expected.put('!', 3);

		assertEquals(expected, uniqueCharCounter.countChars("1)**hello world!!!"));
	}

	@Test
	void givenTextOfNonLetters_whenCharCounter_thenEmptyText() {
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('4', 1);
		expected.put('3', 2);
		expected.put('$', 2);
		expected.put('%', 3);
		expected.put('^', 3);
		expected.put('&', 3);
		expected.put('*', 2);
		expected.put(' ', 2);
		expected.put(')', 1);
		expected.put('(', 1);

		assertEquals(expected, uniqueCharCounter.countChars("43$%^&* )(*&^% $%^&3"));
	}
}
