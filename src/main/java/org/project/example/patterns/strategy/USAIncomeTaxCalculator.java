package org.project.example.patterns.strategy;

import java.time.YearMonth;

public class USAIncomeTaxCalculator implements IncomeTaxCalculator {

	public double calculate(double base, YearMonth yearMonth) {
		return base * 0.30;
	}

}
