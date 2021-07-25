package ua.com.foxminded.charcounter;

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharacterCounter implements CharCounter {

	@Override
	public Map<Character, Integer> countChars(String text) {
		if (text == null) {
			throw new IllegalArgumentException("text cannot be null.");
		}

		Map<Character, Integer> result = new LinkedHashMap<>();
		text.chars().forEach(charAsInt -> result.merge((char) charAsInt, 1, Integer::sum));

		return result;
	}
}
