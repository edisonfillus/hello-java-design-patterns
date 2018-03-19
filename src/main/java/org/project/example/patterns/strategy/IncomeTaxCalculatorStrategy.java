package org.project.example.patterns.strategy;

import java.util.Arrays;

public enum IncomeTaxCalculatorStrategy {

	// To add a new Strategy, just create a class that implement the interface
	// 'IncomeTaxCalculator' and add it here

	BRAZIL(1, new BrazilIncomeTaxCalculator()), 
	USA(2, new USAIncomeTaxCalculator()), 
	CANADA(3, new CanadaIncomeTaxCalculator());

	private int id;
	private IncomeTaxCalculator incomeTaxCalculator;

	private IncomeTaxCalculatorStrategy(int id, IncomeTaxCalculator incomeTaxCalculator) {
		this.id = id;
		this.incomeTaxCalculator = incomeTaxCalculator;
	}

	public int getId() {
		return id;
	}

	public IncomeTaxCalculator getIncomeTaxCalculator() {
		return incomeTaxCalculator;
	}

	/***
	 * Find a IncomeTaxCalculatorStrategy by ID
	 * @param id
	 * @return The IncomeTaxCalculatorStrategy, if found. Null if not found.
	 */
	public static IncomeTaxCalculatorStrategy findById(final int id) {
		return Arrays.asList(IncomeTaxCalculatorStrategy.values()).stream().filter(i -> i.getId() == id).findFirst()
				.orElse(null);
	}

}
