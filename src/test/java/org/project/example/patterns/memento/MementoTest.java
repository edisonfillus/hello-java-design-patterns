package org.project.example.patterns.memento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Test;

public class MementoTest {

	@Test
	public void shoudStoreAndRestoreClientState() {

		ClientHistory history = new ClientHistory();

		Client client = new Client();
		client.setName("Edison");
		client.setAddress("My old address");
		client.setTelephone("My old phone");

		// Create snapshot
		history.addClientSnapshot(client.createSnapshot(new RealServerClock()));

		// Change client data
		client.setAddress("My new address");
		client.setTelephone("My new phome");

		// Ops.. let's undo
		client.restoreStateFromSnapshot(history.popLastClientSnapshot());

		assertEquals("My old address", client.getAddress());
		assertEquals("My old phone", client.getTelephone());

	}

	@Test
	public void shoudRestoreClientStateToSpecificTime() {

		ServerClock clock = mock(ServerClock.class);

		// Calendar for 10h
		Calendar isTen = Calendar.getInstance();
		isTen.set(2018, Calendar.MARCH, 20, 10, 0, 0);

		// Calendar for 11h
		Calendar isEleven = Calendar.getInstance();
		isEleven.set(2018, Calendar.MARCH, 20, 11, 0, 0);

		// Calendar for 12h
		Calendar isTwelve = Calendar.getInstance();
		isTwelve.set(2018, Calendar.MARCH, 20, 12, 0, 0);

		// teach mock to say that "now" is 10h!
		when(clock.now()).thenReturn(isTen);

		ClientHistory history = new ClientHistory();

		Client client = new Client();
		client.setName("Edison");
		client.setAddress("My old address");
		client.setTelephone("My old phone");

		// Create snapshot for 10h
		history.addClientSnapshot(client.createSnapshot(clock));

		// Change client data
		client.setAddress("My new address");
		client.setTelephone("My new phone");

		// teach mock to say that "now" is 11h!
		when(clock.now()).thenReturn(isEleven);

		// Create snapshot for 11h
		history.addClientSnapshot(client.createSnapshot(clock));

		// Change client data
		client.setAddress("My newest address");
		client.setTelephone("My newest phome");

		// teach mock to say that "now" is 12h!
		when(clock.now()).thenReturn(isTwelve);

		// Create snapshot for 12h
		history.addClientSnapshot(client.createSnapshot(clock));

		// Ops, I want to return in time.. what was my state at 10h30?
		Calendar isTenHalf = Calendar.getInstance();
		isTenHalf.set(2018, Calendar.MARCH, 20, 10, 30, 0);

		client.restoreStateFromSnapshot(history.getClientSnapshotInDate(isTenHalf.getTime()));

		assertEquals("My old address", client.getAddress());
		assertEquals("My old phone", client.getTelephone());

		// Ops, I want to return in time.. what was my state at 11h30?
		Calendar isElevenHalf = Calendar.getInstance();
		isElevenHalf.set(2018, Calendar.MARCH, 20, 11, 30, 0);

		client.restoreStateFromSnapshot(history.getClientSnapshotInDate(isElevenHalf.getTime()));

		assertEquals("My new address", client.getAddress());
		assertEquals("My new phone", client.getTelephone());

	}

}
