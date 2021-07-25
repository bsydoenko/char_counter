package ua.com.foxminded.charcounter;

import java.util.HashMap;
import java.util.Map;

public class CacheDecorator extends CharCounterDecorator {

	private Map<String, Map<Character, Integer>> cache = new HashMap<>();

	public CacheDecorator(CharCounter charCounter) {
		super(charCounter);
	}

	@Override
	public Map<Character, Integer> countChars(String text) {
		Map<Character, Integer> result;
		if (cache.containsKey(text)) {
			result = cache.get(text);
		} else {
			result = charCounter.countChars(text);
		}
		// result = cache.getOrDefault(text, charCounter.countChars(text));
		
		cache.putIfAbsent(text, result);
		return result;
	}

}
