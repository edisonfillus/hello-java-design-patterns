package org.project.example.patterns.strategy;

import java.time.YearMonth;

public class PaySlip {

	private final Country country;
	private final Employee employee;
	private final YearMonth yearMonth;
	private final double gross;
	private final double taxes;
	private final double net;

		
	public PaySlip(Country country, Employee employee, YearMonth yearMonth, double gross) {
		super();
		this.country = country;
		this.employee = employee;
		this.yearMonth = yearMonth;
		this.gross = gross;
		taxes = country.getIncomeTaxCalculatorStrategy().getIncomeTaxCalculator().calculate(gross,yearMonth);
		net = gross - taxes;
	}

	public Employee getEmployee() {
		return employee;
	}
	
	public double getGross() {
		return gross;
	}

	public double getTaxes() {
		return taxes;
	}
		
	public double getNet() {
		return net;
	}

	public Country getCountry() {
		return country;
	}

	public YearMonth getYearMonth() {
		return yearMonth;
	}

	
	
}
