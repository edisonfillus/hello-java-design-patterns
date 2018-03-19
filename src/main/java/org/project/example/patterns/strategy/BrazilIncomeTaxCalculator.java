package org.project.example.patterns.strategy;

import java.time.YearMonth;

public class BrazilIncomeTaxCalculator implements IncomeTaxCalculator {

	public double calculate(double income, YearMonth yearMonth) {
		return income * 0.275;
	}

}
