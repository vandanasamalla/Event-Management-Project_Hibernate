package com.EventManagement.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Sponsorship {
	@Override
	public String toString() {
		return "Sponsorship [sponsor_id=" + sponsor_id + ", sponsor_name=" + sponsor_name + ", sponsor_amount="
				+ sponsor_amount + ", event_id=" + event_id + "]";
	}

	@Id
	private String sponsor_id;
	private String sponsor_name;
	private int sponsor_amount;
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private Events event_id;

	public Sponsorship(String sponsor_id, String sponsor_name, int sponsor_amount, Events event_id) {
		super();
		this.sponsor_id = sponsor_id;
		this.sponsor_name = sponsor_name;
		this.sponsor_amount = sponsor_amount;
		this.event_id = event_id;
	}

	public Sponsorship() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSponsor_id() {
		return sponsor_id;
	}

	public void setSponsor_id(String sponsor_id) {
		this.sponsor_id = sponsor_id;
	}

	public String getSponsor_name() {
		return sponsor_name;
	}

	public void setSponsor_name(String sponsor_name) {
		this.sponsor_name = sponsor_name;
	}

	public int getSponsor_amount() {
		return sponsor_amount;
	}

	public void setSponsor_amount(int sponsor_amount) {
		this.sponsor_amount = sponsor_amount;
	}

	public Events getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Events event_id) {
		this.event_id = event_id;
	}
	

}
