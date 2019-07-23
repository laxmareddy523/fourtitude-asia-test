package com.fourtitudeasia.test.basicTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.fourtitudeasia.test.basic.Task1;
import com.fourtitudeasia.test.entity.LoanInfo;

@RunWith(MockitoJUnitRunner.class)
public class Task1_Basic_Test {

	private Task1 bankHousingLoanService;

	@Before
	public void setUp() {
		initMocks(this);
		bankHousingLoanService = new Task1();
	}

	@Test
	public void testBankHousingLoan() {

		String finalResult = bankHousingLoanService.calculateFixedRateMortage(mockLoan());
		assertThat(finalResult).isEqualTo("1,909.66");
	}

	private LoanInfo mockLoan() {
		LoanInfo loanInfo = new LoanInfo();

		loanInfo.setFixedInterestRate(4.00);
		loanInfo.setLoanPrinciple(400000);
		loanInfo.setNumberOfyears(30);
		return loanInfo;

	}
}
