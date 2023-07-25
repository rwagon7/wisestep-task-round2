package service;

import org.springframework.stereotype.Service;

@Service
public class RandomUrlGenerator {

	public static String getRandomURL() {
		return getRandomAlphaString(10);
	}

	public static String getRandomAlphaString(int length) {
		StringBuilder stringbuilder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			char character = (char) (65 + (int) (Math.random() * (90 - 65)));
			stringbuilder.append(character);
		}

		return stringbuilder.toString();
	}

}
