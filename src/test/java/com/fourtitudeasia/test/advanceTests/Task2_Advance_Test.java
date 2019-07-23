package com.fourtitudeasia.test.advanceTests;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.fourtitudeasia.test.advance.Task2_Advance;

@RunWith(MockitoJUnitRunner.class)
public class Task2_Advance_Test {

	Task2_Advance checkDigitsDistributionService;

	@Before
	public void setUp() {
		initMocks(this);
		checkDigitsDistributionService = new Task2_Advance();
	}

	@Test
	public void testCheckDigitsDistribution() {
		int min = 1;
		int max = 1_000_000;
		checkDigitsDistributionService.calculateCheckDigitListDistibution(max, min);

	}
}
