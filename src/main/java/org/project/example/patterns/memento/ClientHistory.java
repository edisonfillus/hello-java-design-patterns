package org.project.example.patterns.memento;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Deque;
import java.util.List;

/**
 * This class store the historical data of Client. In Memento pattern it is
 * called CareTaker
 * 
 * @author Edison Klafke Fillus
 *
 */
public class ClientHistory {

	private List<ClientSnapshot> history; // List if you need to restore any state,
	private Deque<ClientSnapshot> deque; // Deque if you need pop/push last element.

	public ClientHistory() {
		history = new ArrayList<>();
		deque = new ArrayDeque<>();
	}

	public void addClientSnapshot(ClientSnapshot snapshot) {
		history.add(snapshot);
		deque.push(snapshot);
	}

	/**
	 * Return the last state of ClientSnapshot, not remove it
	 * 
	 * @return
	 */
	public ClientSnapshot getLastClientSnapshot() {
		return history.get(history.size() - 1);
	}

	/**
	 * Return the last state of ClientSnapshot, remove it
	 * 
	 * @return
	 */
	public ClientSnapshot popLastClientSnapshot() {
		ClientSnapshot snapshot = history.get(history.size() - 1);
		history.remove(history.size() - 1); // pop the list
		deque.pop(); // or pop the deque
		return snapshot;
	}

	/**
	 * Return the History of ClientSnapshot, if it is possible to select any state
	 * 
	 * @return
	 */
	public List<ClientSnapshot> getClientSnapshotHistory() {
		return Collections.unmodifiableList(history);
	}

	/**
	 * Return the ClientSnapshot in a specific date
	 * 
	 * @param date
	 * @return
	 */
	public ClientSnapshot getClientSnapshotInDate(Date date) {
		// With Java 8 Stream get very easy
		return history.stream().filter(c -> c.getDate().before(date))
				.sorted(Comparator.comparing(ClientSnapshot::getDate).reversed()).findFirst().orElse(null);
	}

}
