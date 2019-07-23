package com.fourtitudeasia.test.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Task2 {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public int calculateCheckDigit(String input) {

		int checkDigit = 0;
		long inputValue = Long.parseLong(input);

		int[] digits = parsNumber(inputValue);

		for (int i = 0; i < digits.length; i++) {
			checkDigit = checkDigit + digits[i];

			if ((checkDigit % 2) == 0) {
				checkDigit /= 2;
			} else {
				checkDigit = (checkDigit - 1) / 2;
			}
		}

		return checkDigit;

	}

	private int[] parsNumber(long inputValue) {

		int count = calculateNumberLength(inputValue);
		long temp = inputValue;

		int[] digits = new int[count];
		while (count != 0) {
			count--;
			digits[count] = (int) (temp % 10);
			temp /= 10;
		}
		return digits;

	}

	private int calculateNumberLength(long inputValue) {
		int count = 0;

		while (inputValue != 0) {
			inputValue /= 10;
			++count;
		}

		return count;
	}

	public String addCheckDigit(String inputValue, int checkDigit) {

		String result = String.valueOf(inputValue) + checkDigit;
		logger.info("Input Value is: {}", inputValue);
		logger.info("Check Digit is: {}", checkDigit);
		logger.info("Check Digit for the value: {} ", result);

		return result;
	}
}
