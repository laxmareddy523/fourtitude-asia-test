package com.fourtitudeasia.test.basicTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.fourtitudeasia.test.basic.Task2;

@RunWith(MockitoJUnitRunner.class)
public class Task2_Basic_Test {

	private Task2 checkDigitCalculatorService;

	@Before
	public void setUp() {
		initMocks(this);
		checkDigitCalculatorService = new Task2();
	}

	@Test
	public void testCheckDigitCalculator() {

		String input = "98062477123";

		int checkDigit = checkDigitCalculatorService.calculateCheckDigit(input);

		String result = checkDigitCalculatorService.addCheckDigit(input, checkDigit);

		assertThat(result).isEqualTo("980624771232");
	}

}
