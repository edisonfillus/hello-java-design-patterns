package org.project.example.patterns.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.YearMonth;

import org.junit.Test;

public class StrategyTest {

	public Country brazil = new Country(1, "Brazil", IncomeTaxCalculatorStrategy.BRAZIL);
	public Country canada = new Country(1, "Canada", IncomeTaxCalculatorStrategy.CANADA);
	public Country usa = new Country(1, "USA", IncomeTaxCalculatorStrategy.USA);
	public Employee peter = new Employee(1, "Peter");

	@Test
	public void shouldCalculateTaxesBrazilCorrect() {
		PaySlip payForBrazil = new PaySlip(brazil, peter, YearMonth.of(2018, 03), 10000.00);

		assertEquals(2750.00, payForBrazil.getTaxes());
		assertEquals(7250.00, payForBrazil.getNet());

	}

	@Test
	public void shouldCalculateTaxesUSACorrect() {
		PaySlip payForUSA = new PaySlip(usa, peter, YearMonth.of(2018, 03), 10000.00);

		assertEquals(3000.00, payForUSA.getTaxes());
		assertEquals(7000.00, payForUSA.getNet());

	}

	@Test
	public void shouldCalculateTaxesCanadaCorrect() {
		PaySlip payForCanada = new PaySlip(canada, peter, YearMonth.of(2018, 03), 10000.00);

		assertEquals(2500.00, payForCanada.getTaxes());
		assertEquals(7500.00, payForCanada.getNet());

	}
}
