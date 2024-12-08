package com.EventManagement.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Venues {
	@Override
	public String toString() {
		return "Venues [venue_id=" + venue_id + ", venue_name=" + venue_name + ", address=" + address + ", capacity="
				+ capacity + ", event_id=" + event_id + "]";
	}
	@Id
	private int venue_id;
	private String venue_name;
	private String address;
	private int capacity;
	@ManyToOne
	@JoinColumn(name="event-id")
	private Events event_id;
	public int getVenue_id() {
		return venue_id;
	}
	public void setVenue_id(int venue_id) {
		this.venue_id = venue_id;
	}
	public String getVenue_name() {
		return venue_name;
	}
	public Venues() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setVenue_name(String venue_name) {
		this.venue_name = venue_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Venues(int venue_id, String venue_name, String address, int capacity, Events event_id) {
		super();
		this.venue_id = venue_id;
		this.venue_name = venue_name;
		this.address = address;
		this.capacity = capacity;
		this.event_id = event_id;
	}
	public Events getEvent_id() {
		return event_id;
	}
	public void setEvent_id(Events event_id) {
		this.event_id = event_id;
	}
}
