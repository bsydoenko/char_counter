package ua.com.foxminded.charcounter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharCounter {

	private Map<String, Map<Character, Integer>> previousResults = new HashMap<>();

	public Map<Character, Integer> countChar(String text) {
		if (text == null) {
			throw new IllegalArgumentException("text cannot be null.");
		}

		if (previousResults.containsKey(text)) {
			return previousResults.get(text);
		}

		char[] charsOfText = text.toCharArray();
		Map<Character, Integer> result = СountСharacterRepetitions(charsOfText);

		previousResults.put(text, result);
		return result;
	}

	private Map<Character, Integer> СountСharacterRepetitions(char[] charsOfText) {
		Map<Character, Integer> numbersOfRepetitionOfCharacters = new LinkedHashMap<>();

		for (char ch : charsOfText) {
			if (!numbersOfRepetitionOfCharacters.containsKey(ch)) {
				numbersOfRepetitionOfCharacters.put(ch, 1);
			} else {
				numbersOfRepetitionOfCharacters.put(ch, numbersOfRepetitionOfCharacters.get(ch) + 1);
			}
		}
		return numbersOfRepetitionOfCharacters;
	}
}
