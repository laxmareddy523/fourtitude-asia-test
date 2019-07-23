package com.fourtitudeasia.test.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Task3 {

	private final long modulus;
	private final int multiplier;
	private final int increment;
	private long seed;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public Task3(long modulus, int multiplier, int increment, long seed) {
		this.modulus = modulus;
		this.multiplier = multiplier;
		this.increment = increment;
		this.seed = seed;
	}

	public void checkSequenceNumbers(int sequenceLenght) {
		long[] sequence = sequenceGenerator(sequenceLenght);
		long[] result = new long[sequence.length];

		for (int i = 0; i < sequence.length; i++) {
			if (isPrime(sequence[i])) {
				result[i] = sequence[i];
			}
		}

	}

	private long[] sequenceGenerator(int sequenceLenght) {
		long[] sequence = new long[sequenceLenght];
		for (int i = 0; i < sequenceLenght; i++) {
			sequence[i] = next();
		}
		return sequence;
	}

	// @NotThreadSafe
	public /* synchronized */ long next() {
		// Y = (a.X + c) mod m
		long val = (multiplier * seed) + increment;
		seed = val % modulus;
		return seed;
	}

	private boolean isPrime(long input) {

		if ((input == 0 || input == 1) || (input > 2 && input % 2 == 0)) {
			return false;
		}
		for (int val = 2; val <= (input / 2); val++) {
			if (input % val == 0) {
				return false;
			}
		}
		logger.info("{} is prime", input);
		return true;
	}

}
