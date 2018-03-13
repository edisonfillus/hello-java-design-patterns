package org.project.example.patterns.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class StrategyTest {

	@Test
	public void shouldCalculateTaxesBrazilCorrect() {
		PaySlip payForBrazil = new PaySlip("Pedro", 10000.00, new BrazilIncomeTaxStrategy());
		
		assertEquals(2500.00, payForBrazil.getTaxes());
		assertEquals(7500.00, payForBrazil.getNet());
		
	}
	
	@Test
	public void shouldCalculateTaxesUSACorrect() {
		PaySlip payForUSA = new PaySlip("Peter", 10000.00, new USAIncomeTaxStrategy());
		
		assertEquals(3000.00, payForUSA.getTaxes());
		assertEquals(7000.00, payForUSA.getNet());
		
	}
}
