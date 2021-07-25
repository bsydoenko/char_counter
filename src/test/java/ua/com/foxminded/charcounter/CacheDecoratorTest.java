package ua.com.foxminded.charcounter;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CacheDecoratorTest {

	@Mock
	UniqueCharacterCounter uniqueCharacterCounter;
	
	@InjectMocks
	CacheDecorator cacheDecorator;
	
	@Test
	void test() {
		String testString = "Hello world!!!";
		for (int i = 0; i < 2; i++) {
			cacheDecorator.countChars(testString);
		}
		verify(uniqueCharacterCounter).countChars(testString);
	}
}
