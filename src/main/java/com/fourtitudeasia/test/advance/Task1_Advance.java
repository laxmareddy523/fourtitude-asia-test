package com.fourtitudeasia.test.advance;

import java.text.NumberFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.fourtitudeasia.test.entity.LoanInfo;

@Service
public class Task1_Advance {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public String calculateInterastRate(LoanInfo loanInfo, double repaymentAmount) {

		double totalInterest;
		double totalAmount;
		double oneYearTotalInterest;

		totalAmount = repaymentAmount * loanInfo.getNumberOfyears() * 12;
		totalInterest = totalAmount - loanInfo.getLoanPrinciple();
		oneYearTotalInterest = totalInterest / loanInfo.getNumberOfyears();

		double fixedInterestRate = 0L;
		if (repaymentAmount <= 1500) {
			fixedInterestRate = (100 * oneYearTotalInterest)
					/ (loanInfo.getLoanPrinciple() * loanInfo.getNumberOfyears());

			loanInfo.setFixedInterestRate(fixedInterestRate);

		}

		NumberFormat defaultFormat = NumberFormat.getPercentInstance();
		defaultFormat.setMinimumFractionDigits(2);

		logger.info("Interest rate is :: {} ", defaultFormat.format(loanInfo.getFixedInterestRate()));

		return defaultFormat.format(loanInfo.getFixedInterestRate());
	}

}
