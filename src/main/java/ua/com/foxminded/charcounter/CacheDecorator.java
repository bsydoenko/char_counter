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
		return cache.computeIfAbsent(text, k -> charCounter.countChars(text));
	}

}
