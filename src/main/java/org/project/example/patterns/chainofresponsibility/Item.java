package org.project.example.patterns.chainofresponsibility;

public class Item {

	private final String name;
	private final int quantity;
	private final double unitPrice;
	private final double total;

	public Item(String name, int quantity, double unitPrice) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.total = unitPrice * quantity;
	}

	public String getName() {
		return name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public double getTotal() {
		return total;
	}
}
