package com.EventManagement.Entities;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Events {

    @Id
    private int event_id;
    private String event_name;

	private Date date;  // Use java.sql.Date for better SQL compatibility
    private String location;

    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false) // Explicit reference
    private Organizer organizer_id;

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Organizer getOrganizer_id() {
		return organizer_id;
	}

	public void setOrganizer_id(Organizer organizer_id) {
		this.organizer_id = organizer_id;
	}

	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Events [event_id=" + event_id + ", event_name=" + event_name + ", date=" + date + ", location="
				+ location + ", organizer_id=" + organizer_id + "]";
	}


    
   }
