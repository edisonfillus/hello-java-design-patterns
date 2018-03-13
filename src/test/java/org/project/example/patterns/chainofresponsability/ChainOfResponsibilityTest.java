package org.project.example.patterns.chainofresponsability;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class ChainOfResponsibilityTest {
	
	private static ApplyDiscount currentDiscountPolicy;
	
	@BeforeClass
	public static void initialization() {
		ApplyDiscount discountByVolume = new ApplyVolumeDiscount();
		ApplyDiscount discountByValue = new ApplyValueDiscount();
		ApplyDiscount noDiscount = new ApplyNoDiscount();
		
		//Defines that Discount by Volume comes first, then Discount by Value, then No Discount
		discountByVolume.setSuccessor(discountByValue);
		discountByValue.setSuccessor(noDiscount);
				
		currentDiscountPolicy = discountByVolume;
	}
	
	@Test
	public void shouldApplyNoDiscount() {
		Estimate estimate = new Estimate(currentDiscountPolicy);
		estimate.addItem(new Item("Coke",1, 1.0));
		
		//Just one item, must apply NoDiscount
		assertEquals(0.0, estimate.getDiscount());
		
	}
	
	@Test
	public void shouldApplyDiscountByVolume() {
		Estimate estimate = new Estimate(currentDiscountPolicy);
		estimate.addItem(new Item("Coke",10, 1.0));
		
		//Just one item, must apply NoDiscount
		assertEquals(1.0, estimate.getDiscount());
		
	}
	
	@Test
	public void shouldApplyDiscountByValue() {
		Estimate estimate = new Estimate(currentDiscountPolicy);
		estimate.addItem(new Item("Macbook",1, 1000.0));
		
		//Just one item, must apply NoDiscount
		assertEquals(80.0, estimate.getDiscount());
		
	}
	
	
	
}
