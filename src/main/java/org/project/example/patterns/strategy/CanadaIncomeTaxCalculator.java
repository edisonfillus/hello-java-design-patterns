package org.project.example.patterns.strategy;

import java.time.YearMonth;

public class CanadaIncomeTaxCalculator implements IncomeTaxCalculator {

	public double calculate(double base, YearMonth yearMonth) {
		return base * 0.25;
	}


}
