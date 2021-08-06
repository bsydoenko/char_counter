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
	CharCounter charCounter;
	
	@InjectMocks
	CacheDecorator cacheDecorator;
	
	@Test
	void givenTextTwice_whenCachedCharCounter_thenCharCounterCalledOnce() {
		String testString = "Hello world!!!";
		
		cacheDecorator.countChars(testString);
		cacheDecorator.countChars(testString);
		verify(charCounter).countChars(testString);
	}
}
