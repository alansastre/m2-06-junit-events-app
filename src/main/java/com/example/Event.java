package com.example;

import com.example.service.EventNotificationService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// SUT system under test o Class Under Test
public class Event {

    /*======================================= ATRIBUTOS =======================================*/

    private Long id;
    private String title;
    private EventType type;
    private List<Speaker> speakers = new ArrayList<>();
    private List<Attendee> attendees = new ArrayList<>();

    private EventNotificationService eventNotificationService; // mock

    public Event(){

    }

    public Event(Long id, String title, EventType type, EventNotificationService eventNotificationService) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.eventNotificationService = eventNotificationService;
    }

    /*======================================= CASUISTICA: 1 ASISTENTE =======================================*/

    /**
     * AÑADIR ASISTENTE 
     */
    public void addAttendee(Attendee attendee){
        if(attendee == null)
            return;

        if (this.getAttendees() == null)
            this.setAttendees(new ArrayList<>());

        if (!this.getAttendees().contains(attendee))
            this.getAttendees().add(attendee);
    }
    
    /**
	BORRAR ASISTENTE
     */
    public void removeAttendee(Attendee attendee){
        if(attendee == null)
            return;

        if (this.getAttendees() == null)
            this.setAttendees(new ArrayList<>());

        this.getAttendees().remove(attendee);
    }

    
    /*======================================= CASUISTICA: VARIOS ASISTENTES =======================================*/

    public void addAttendees(List<Attendee> attendees){
        if(attendees == null)
            return;

        if (this.getAttendees() == null)
            this.setAttendees(new ArrayList<>());

        for (Attendee attendee : attendees) {
            if (!this.getAttendees().contains(attendee))
                this.getAttendees().add(attendee);
        }

    }


    public void removeAttendees(List<Attendee> attendees){
        if(attendees == null)
            return;

        if (this.getAttendees() == null)
            this.setAttendees(new ArrayList<>());

        this.getAttendees().removeIf(attendees::contains);

    }
    
    /*======================================= CASUISTICA:  SPEAKERS =======================================*/

    public void addSpeaker(Speaker speaker){
        if (speaker == null)
            return;
        this.getSpeakers().add(speaker);
    }

    public void removeSpeaker(Speaker speaker){
        if (speaker == null)
            return;
        this.getSpeakers().remove(speaker);
    }
    
    
    /*======================================= CASUISTICA: METODOS QUE DEPENDEN DEL SERVICIO =======================================*/

    public void notifyAssistants(){
    	this.eventNotificationService.announce(this);
    }



    /*======================================= GETTER Y SETTER =======================================*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }
}
