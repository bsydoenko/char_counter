/*
 * @author    Bohdan Sydorenko
 *
 * Copyright (c) Foxminded, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Foxminded
 * Microsystems, Inc. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Foxminded.
 *
 * FOXMINDED MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. SUN SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

package ua.com.foxminded.charcounter;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		CharCounter charCounter = new CacheDecorator(new UniqueCharacterCounter());

		while (true) {
			System.out.print("Enter text: ");
			String inputText = scanner.nextLine();
			if (inputText.equalsIgnoreCase("q")) {
				scanner.close();
				System.out.println("Good Bye!");
				System.exit(0);
			} else {
				printResult(charCounter.countChars(inputText));
			}
		}
	}

	private static void printResult(Map<Character, Integer> result) {
		for (Entry<Character, Integer> entry : result.entrySet()) {
			System.out.println("\"" + entry.getKey() + "\"" + " - " + entry.getValue());
		}
	}
}
