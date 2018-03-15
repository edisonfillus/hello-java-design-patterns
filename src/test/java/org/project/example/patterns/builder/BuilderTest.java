package org.project.example.patterns.builder;

import org.junit.Test;

public class BuilderTest {

	@Test
	public void testBuilder() {
		BankAccount account = new BankAccount.Builder(1234L).withOwner("Marge").atBranch("Springfield")
				.openingBalance(100).atRate(2.5).build();
		
		BankAccount anotherAccount = new BankAccount.Builder(4567L).withOwner("Homer").atBranch("Springfield")
				.openingBalance(100).atRate(2.5).build();
		
		//new BankAccount(); In this variation, it's not possible to call the constructor directly
	}

}
