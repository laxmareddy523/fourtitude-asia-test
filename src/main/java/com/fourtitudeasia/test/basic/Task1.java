package com.fourtitudeasia.test.basic;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fourtitudeasia.test.entity.LoanInfo;

@Service
public class Task1 {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public String calculateFixedRateMortage(LoanInfo loanInfo) {

		int numberOfPayments;
		double percentageRate;
		double repaymentAmount;

		numberOfPayments = loanInfo.getNumberOfyears() * 12;
		percentageRate = (loanInfo.getFixedInterestRate() / 100) / 12;

		double arg0 = 1 + percentageRate;
		long arg1 = -numberOfPayments;
		double power = Math.pow(arg0, arg1);

		repaymentAmount = loanInfo.getLoanPrinciple() * (percentageRate / (1 - power));

		String finalResult = putDecimalFormat(repaymentAmount);
		String loanPrinciple = putDecimalFormat(loanInfo.getLoanPrinciple());

		logger.info(
				"The monthly repayment of a loan of RM {} with fixed interest rate " + '\n'
						+ " of {}% per annum, over a period of {} years is :: {} ",
				loanPrinciple, loanInfo.getFixedInterestRate(), loanInfo.getNumberOfyears(), finalResult);

		return finalResult;

	}

	private String putDecimalFormat(double repaymentAmount) {

		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
		decimalFormatSymbols.setDecimalSeparator('.');
		decimalFormatSymbols.setGroupingSeparator(',');
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", decimalFormatSymbols);
		String finalResult = decimalFormat.format(repaymentAmount);

		return finalResult;
	}
}
