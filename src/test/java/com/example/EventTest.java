package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.service.EventNotificationServiceImpl;


class EventTest {

	Event event;
	@BeforeEach
	void setUp() throws Exception {
		event = new Event();
	}

	@Test
	void testAddAttendee() {
		
		assertEquals(0, event.getAttendees().size());
		
		Attendee person1 = new Attendee(1L , "Persona1", "");
		Attendee person2 = new Attendee(2L , "Persona2", "");
		event.addAttendee(person1);
		assertEquals(1, event.getAttendees().size());
		
		event.addAttendee(person2);
		assertEquals(2, event.getAttendees().size());
		
		assertEquals("Persona1", event.getAttendees().get(0).getNickname());
		assertEquals("Persona2", event.getAttendees().get(1).getNickname());
		
		
	}
	
	@Test
	void testAddAttendeeNull() {
		
		assertEquals(0, event.getAttendees().size());

		event.addAttendee(null);

		assertEquals(0, event.getAttendees().size());

		
	}
	
	@Test
	void testAddAttendeeListNull() throws Exception {
		Event evento = new Event(1L, "El evento del año",
				EventType.BUSINESS, new EventNotificationServiceImpl());
		
		

		
		evento.setAttendees(null);
		assertEquals(null, evento.getAttendees());
		Attendee person1 = new Attendee(1L , "Persona1", "");

		evento.addAttendee(person1);
		assertEquals(1, evento.getAttendees().size());
		
	}
	
	@Test
	void testAddAttendeeAlreadyContains(){
		
		assertEquals(0, event.getAttendees().size());

		Attendee person1 = new Attendee(1L , "Persona1", "");

		event.addAttendee(person1);
		
		assertEquals(1, event.getAttendees().size());

		event.addAttendee(person1);
		
		assertEquals(1, event.getAttendees().size());
		
	}

	@Test
	void testAddAttendees() {
		
	}

	@Test
	void testRemoveAttendee() {
		
	}

	@Test
	void testRemoveAttendees() {
		
	}

	@Test
	void testNotifyAssistants() {
		
	}

	@Test
	void testAddSpeaker() {
		
	}

	@Test
	void testRemoveSpeaker() {
		
	}

}
