package org.project.example.patterns.memento;

public class Client {

	private String name;
	private String address;
	private String telephone;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * This method will save Client current state to a memento
	 * @param clock System Time Clock to use
	 * @return
	 */
	public ClientSnapshot createSnapshot(ServerClock clock) {
		return new ClientSnapshot(name,address,telephone,clock);
	}
	
	/**
	 * This method will restore the state of the Client from an historical memento
	 * @param snapshot The memento that you want to restore state
	 */
	public void restoreStateFromSnapshot(ClientSnapshot snapshot) {
		this.name = snapshot.getName();
		this.address = snapshot.getAddress();
		this.telephone = snapshot.getTelephone();
	}
	
}
