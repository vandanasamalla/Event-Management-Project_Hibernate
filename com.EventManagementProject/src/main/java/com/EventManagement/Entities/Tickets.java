package com.EventManagement.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tickets {
	@Id
	private int Ticket_id;
	private int Ticket_price;
	
	@ManyToOne
	@JoinColumn(name="Event_id")
    private Events Event_id;

	public Tickets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tickets(int ticket_id, int ticket_price, Events event_id) {
		super();
		Ticket_id = ticket_id;
		Ticket_price = ticket_price;
		Event_id = event_id;
	}

	public int getTicket_id() {
		return Ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		Ticket_id = ticket_id;
	}

	public int getTicket_price() {
		return Ticket_price;
	}

	public void setTicket_price(int ticket_price) {
		Ticket_price = ticket_price;
	}

	public Events getEvent_id() {
		return Event_id;
	}

	public void setEvent_id(Events event_id) {
		Event_id = event_id;
	}

	@Override
	public String toString() {
		return "Tickets [Ticket_id=" + Ticket_id + ", Ticket_price=" + Ticket_price + ", Event_id=" + Event_id + "]";
	}

	

}
