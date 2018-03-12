package org.project.example.patterns.strategy;

public class USAIncomeTaxStrategy implements IncomeTaxStrategy {

	@Override
	public double calculate(double base) {
		return base * 0.30;
	}

}
