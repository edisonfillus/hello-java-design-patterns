package org.project.example.patterns.chainofresponsibility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estimate {

	private double total;
	private double discount;
	private final List<Item> items;
	private ApplyDiscount applyDiscount;
	
	public Estimate(ApplyDiscount applyDiscount) {
		this.applyDiscount = applyDiscount;
		items = new ArrayList<>();
	}
	
	public double getTotal() {
		return total;
	}

	public List<Item> getItems() {
		return Collections.unmodifiableList(items);
	}

	public void addItem(Item item) {
		this.items.add(item);
		total += item.getTotal();
		discount = applyDiscount.calculateDiscount(this);
	}

	public double getDiscount() {
		return discount;
	}
	
	
	
	
}
