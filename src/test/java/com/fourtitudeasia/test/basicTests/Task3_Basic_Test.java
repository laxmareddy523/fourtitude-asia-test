package com.fourtitudeasia.test.basicTests;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.fourtitudeasia.test.basic.Task3;

@RunWith(MockitoJUnitRunner.class)
public class Task3_Basic_Test {

	Task3 linearCongruentialGenerator;

	@Before
	public void setUp() {
		initMocks(this);
		linearCongruentialGenerator = new Task3(65536, 137, 1, 0);
	}

	@Test
	public void testCheckDigitCalculator() {
		int sequenceLenght = 100;
		linearCongruentialGenerator.checkSequenceNumbers(sequenceLenght);

	}

}
