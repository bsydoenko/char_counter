package ua.com.foxminded.charcounter;

public abstract class CharCounterDecorator implements CharCounter {

	CharCounter charCounter;

	public CharCounterDecorator(CharCounter charCounter) {
		this.charCounter = charCounter;
	}

}
