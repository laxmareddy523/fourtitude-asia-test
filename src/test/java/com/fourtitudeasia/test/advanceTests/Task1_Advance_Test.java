package com.fourtitudeasia.test.advanceTests;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.fourtitudeasia.test.advance.Task1_Advance;
import com.fourtitudeasia.test.entity.LoanInfo;

@RunWith(MockitoJUnitRunner.class)
public class Task1_Advance_Test {

	Task1_Advance interestRateService;

	@Before
	public void setUp() {
		initMocks(this);
		interestRateService = new Task1_Advance();
	}

	@Test
	public void testInterestRate() {

		double repaymentAmount = 1500;
		interestRateService.calculateInterastRate(mockLoanInfo(), repaymentAmount);

	}

	private LoanInfo mockLoanInfo() {

		LoanInfo loanInfo = new LoanInfo();
		loanInfo.setLoanPrinciple(400000);
		loanInfo.setNumberOfyears(30);

		return loanInfo;
	}
}
