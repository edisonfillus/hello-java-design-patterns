package org.project.example.patterns.strategy;

import java.time.YearMonth;

public interface IncomeTaxCalculator {
	double calculate(double income, YearMonth yearMonth);
}
