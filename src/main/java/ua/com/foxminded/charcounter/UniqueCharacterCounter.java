package ua.com.foxminded.charcounter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueCharacterCounter implements CharCounter {

	@Override
	public Map<Character, Integer> countChars(String text) {
		if (text == null) {
			throw new IllegalArgumentException("text cannot be null.");
		}

		return text.chars().mapToObj(e -> (char) e).collect(Collectors
				.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.reducing(0, e -> 1, Integer::sum)));
	}
}
