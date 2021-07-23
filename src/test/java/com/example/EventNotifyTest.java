package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.service.EventNotificationServiceImpl;

public class EventNotifyTest {



	/**
	 * VERSION SIN MOCKS
	 */
	@Test
	void testNotify() {

		
		EventNotificationServiceImpl notificationService = new EventNotificationServiceImpl();
		
		Event event = new Event(1L, "Title", EventType.MARKETING, notificationService);
		
		Attendee asistente = new Attendee(1L , "Persona1", "");
		event.addAttendee(asistente);
		
		assertEquals(0, asistente.getNotifications().size());
		
		
		event.notifyAssistants();
		
		assertEquals(1, asistente.getNotifications().size());
		assertEquals("The next big event is coming!", asistente.getNotifications().get(0).getMessage());

		
		
	}
	
}
