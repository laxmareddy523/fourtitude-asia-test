package com.fourtitudeasia.test.advance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fourtitudeasia.test.basic.Task2;

@Service
public class Task2_Advance {

	private int[] checkDigitDistibutionList = new int[10];

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private long generateRandomNumber(int max, int min) {

		long randomNumber = (long) (Math.random() * ((max - min) + 1)) + min;
		return randomNumber;
	}

	public void calculateCheckDigitListDistibution(int max, int min) {

		int[] checkDigitDistibutionList = new int[10];

		for (int i = 0; i <= max; i++) {
			long number = this.generateRandomNumber(max, min);
			checkDigitDistibutionList = this.getCheckDigits(number);
		}

		checkDigitDistibution(checkDigitDistibutionList);
	}

	private int[] getCheckDigits(long input) {
		Task2 checkDigitCalculatorService = new Task2();
		String inputStr = String.valueOf(input);
		int checkDigit = checkDigitCalculatorService.calculateCheckDigit(inputStr);

		switch (checkDigit) {

		case 0:
			countDigits(0);
			break;
		case 1:
			countDigits(1);
			break;
		case 2:
			countDigits(2);
			break;
		case 3:
			countDigits(3);
			break;
		case 4:
			countDigits(4);
			break;
		case 5:
			countDigits(5);
			break;
		case 6:
			countDigits(6);
			break;
		case 7:
			countDigits(7);
			break;
		case 8:
			countDigits(8);
			break;
		case 9:
			countDigits(9);
			break;
		default:
			break;

		}

		return checkDigitDistibutionList;
	}

	private void countDigits(int countDigi) {

		if (checkDigitDistibutionList[countDigi] == 0) {
			checkDigitDistibutionList[countDigi] = 1;
		} else {
			checkDigitDistibutionList[countDigi] = checkDigitDistibutionList[countDigi] + 1;
		}

	}

	private void checkDigitDistibution(int[] checkDigitDistibutionList) {

		int first = checkDigitDistibutionList[0];
		int max = checkDigitDistibutionList[0];

		int index = 0;
		for (int i = 0; i < checkDigitDistibutionList.length; i++) {
			if (checkDigitDistibutionList[i] > max) {
				max = checkDigitDistibutionList[i];
				index = i;
			} else if (checkDigitDistibutionList[i] == first) {
				first = checkDigitDistibutionList[i];
			}
		}

		if (max == first) {
			logger.info("The check digits come out (be distributed) equally");
		} else {
			logger.info("The check digit {} highest frequency is: {} ", index, max);
		}

	}

}
