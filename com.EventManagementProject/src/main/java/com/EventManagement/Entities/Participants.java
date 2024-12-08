package com.EventManagement.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Participants {
	@Override
	public String toString() {
		return "Participants [participant_id=" + participant_id + ", participant_name=" + participant_name
				+ ", contact_info=" + contact_info + ", Ticket_id=" + Ticket_id + "]";
	}
	@Id
	 private int participant_id;
	 private String participant_name;
	 public Participants() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String  contact_info;
     @ManyToOne
     @JoinColumn
 
    private Tickets Ticket_id;
	public int getParticipant_id() {
		return participant_id;
	}
	public void setParticipant_id(int participant_id) {
		this.participant_id = participant_id;
	}
	public String getParticipant_name() {
		return participant_name;
	}
	public void setParticipant_name(String participant_name) {
		this.participant_name = participant_name;
	}
	public String getContact_info() {
		return contact_info;
	}
	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}
	public Tickets getTicket_id() {
		return Ticket_id;
	}
	public void setTicket_id(Tickets ticket_id) {
		Ticket_id = ticket_id;
	}
	public Participants(int participant_id, String participant_name, String contact_info, Tickets ticket_id) {
		super();
		this.participant_id = participant_id;
		this.participant_name = participant_name;
		this.contact_info = contact_info;
		Ticket_id = ticket_id;
	}
}
