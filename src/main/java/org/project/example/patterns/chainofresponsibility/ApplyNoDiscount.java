package org.project.example.patterns.chainofresponsibility;

/**
 * Optional Class for Chain of Responsability. It's just useful for code readability
 * @author Edison Klafke Fillus
 *
 */
public class ApplyNoDiscount implements ApplyDiscount {

	@Override
	public double calculateDiscount(Estimate estimate) {
		return 0;
	}

	@Override
	public void setSuccessor(ApplyDiscount successor) {
		//Do nothing, as there is no successor
	}

}
