package org.project.example.patterns.strategy;

public class PaySlip {

	private String employee;
	private double gross;
	private double taxes;
	private double net;
		
	public PaySlip(String employee, double gross, IncomeTaxStrategy taxStrategy) {
		super();
		this.employee = employee;
		this.gross = gross;
		taxes = taxStrategy.calculate(gross);
		net = gross - taxes;
	}

	public String getEmployee() {
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
	
	
}
