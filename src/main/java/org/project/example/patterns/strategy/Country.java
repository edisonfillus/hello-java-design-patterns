package org.project.example.patterns.strategy;

public class Country {

	private int id;
	private String name;
	private IncomeTaxCalculatorStrategy incomeTaxCalculatorStrategy; //This field can be persisted by id on database
	
	public Country(int id, String name, IncomeTaxCalculatorStrategy incomeTaxCalculatorStrategy) {
		super();
		this.id = id;
		this.name = name;
		this.incomeTaxCalculatorStrategy = incomeTaxCalculatorStrategy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IncomeTaxCalculatorStrategy getIncomeTaxCalculatorStrategy() {
		return incomeTaxCalculatorStrategy;
	}

	public void setIncomeTaxCalculatorStrategy(IncomeTaxCalculatorStrategy incomeTaxCalculatorStrategy) {
		this.incomeTaxCalculatorStrategy = incomeTaxCalculatorStrategy;
	}
	
	
	
	
}
