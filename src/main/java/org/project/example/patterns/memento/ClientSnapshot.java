package org.project.example.patterns.memento;

import java.util.Calendar;
import java.util.Date;

/**
 * This is the Memento Class of Client
 * @author Edison Klafke Fillus
 *
 */
public class ClientSnapshot {
	
	private Date date; //If you want to date control
	private String name;
	private String address;
	private String telephone;
	
	public ClientSnapshot(String name, String address, String telephone, ServerClock clock) {
		super();
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.date = clock.now().getTime(); //Get the current time for date controle
	}

	public Date getDate() {
		return date;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getTelephone() {
		return telephone;
	}
	
}
