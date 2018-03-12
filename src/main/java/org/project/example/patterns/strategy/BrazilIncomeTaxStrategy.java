package org.project.example.patterns.strategy;

public class BrazilIncomeTaxStrategy implements IncomeTaxStrategy {

	@Override
	public double calculate(double income) {
		return income * 0.25;
	}

}
