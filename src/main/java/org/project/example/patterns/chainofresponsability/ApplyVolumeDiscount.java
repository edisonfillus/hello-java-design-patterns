package org.project.example.patterns.chainofresponsability;

public class ApplyVolumeDiscount implements ApplyDiscount {

	//Keep the successor on chain
	private ApplyDiscount successor;

	@Override
	public double calculateDiscount(Estimate estimate) {
		// If client bought more than 5 items, give 10% discount
		if (estimate.getItems().stream().mapToInt(Item::getQuantity).sum() > 5) {
			return estimate.getTotal() * 0.1;
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
