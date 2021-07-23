package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.service.EventNotificationServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EventMockTest {

	
	// dependencia (mock)
	@Mock
	EventNotificationServiceImpl notificationService;
	
	// dependiente - Class under test - SUT (no mock)
	@InjectMocks
	Event event;
	
	@Test
	void testName() throws Exception {

		event.notifyAssistants();
		
		verify(notificationService, times(1)).announce(event);
	}
}
