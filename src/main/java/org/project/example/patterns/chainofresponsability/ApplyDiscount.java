package org.project.example.patterns.chainofresponsability;

public interface ApplyDiscount {

	/**
	 * Calculate a discount
	 */
	double calculateDiscount(Estimate estimate);
	
	/**
	 * Set the successor on Chain of Responsibility
	 */
	void setSuccessor(ApplyDiscount applyDiscount);
}
