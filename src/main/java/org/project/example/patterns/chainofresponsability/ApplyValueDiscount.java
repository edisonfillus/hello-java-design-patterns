package org.project.example.patterns.chainofresponsability;

public class ApplyValueDiscount implements ApplyDiscount {

	// Keep the successor on chain
	private ApplyDiscount successor;

	@Override
	public double calculateDiscount(Estimate estimate) {
		// If client bought more than 500.00 , give 8% discount
		if (estimate.getTotal() > 500.0) {
			return estimate.getTotal() * 0.08;
		}
		// Or else, call successor if exist
		if (successor != null) {
			return successor.calculateDiscount(estimate);
		}
		// If there is no successor, return 0
		return 0;

	}

	/**
	 * Set the successor on Chain of Responsibility
	 */
	@Override
	public void setSuccessor(ApplyDiscount successor) {
		this.successor = successor;
	}

}
