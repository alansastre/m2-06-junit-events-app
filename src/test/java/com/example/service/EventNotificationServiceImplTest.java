package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Attendee;
import com.example.Event;
import com.example.EventType;

class EventNotificationServiceImplTest {

	EventNotificationServiceImpl service ;
	Event event;
	
	
	@BeforeEach
	void setUp() throws Exception {
		service = new EventNotificationServiceImpl();
		event = new Event(1L, "", EventType.MARKETING, service);
	}

	@Test
	void testNulos() {

		Attendee asistente1 = new Attendee();
		event.addAttendee(asistente1);
		
		//
		assertEquals(0, asistente1.getNotifications().size());
		service.announce(null);
		assertEquals(0, asistente1.getNotifications().size());

		// 
		event.setAttendees(null);
		service.announce(event);
		assertEquals(0, asistente1.getNotifications().size());

		// 
		event.setAttendees(new ArrayList<Attendee>());
		service.announce(event);
		assertEquals(0, asistente1.getNotifications().size());

	}
	
	@Test
	void test1Asistente() throws Exception {
		// un asistente
		Attendee asistente1 = new Attendee();
		event.addAttendee(asistente1);
		service.announce(event);
		assertEquals(1, asistente1.getNotifications().size());
		
		service.announce(event);
		assertEquals(2, asistente1.getNotifications().size());
	}

	@Test
	void testMultiplesAsistentes() throws Exception {
		// creacion de datos preparacion del entorno
		Attendee asistente1 = new Attendee(1L, "user1", "user1");
		event.addAttendee(asistente1);
		Attendee asistente2 = new Attendee(2L, "user2", "user2");
		event.addAttendee(asistente2);
		
		// ejecutar el metodo a testear
		service.announce(event);
		
		// comprobaciones
		assertEquals(1, asistente1.getNotifications().size());
		assertEquals(1, asistente2.getNotifications().size());
		
		// ejecutar el metodo a testear
		service.announce(event);
		
		// comprobaciones
		assertEquals(2, asistente1.getNotifications().size());
		assertEquals(2, asistente2.getNotifications().size());
	}

}
