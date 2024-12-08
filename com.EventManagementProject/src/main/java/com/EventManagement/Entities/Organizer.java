package com.EventManagement.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Organizer {
	@Id
	private int organizer_id;
	private String organizer_name;
	private String organizer_info;
	public int getOrganizer_id() {
		return organizer_id;
	}
	public void setOrganizer_id(int organiser_id) {
		this.organizer_id = organiser_id;
	}
	public String getOrganizer_name() {
		return organizer_name;
	}
	public void setOrganizer_name(String organizer_name) {
		this.organizer_name = organizer_name;
	}
	public String getOrganizer_info() {
		return organizer_info;
	}
	public void setOrganizer_info(String organizer_info) {
		this.organizer_info = organizer_info;
	}
	public Organizer() {
		super();
		this.organizer_id = organizer_id;
		this.organizer_name = organizer_name;
		this.organizer_info = organizer_info;
	}
	
	@Override
	public String toString() {
		return "Organizer [organizer_id=" + organizer_id + ", organizer_name=" + organizer_name + ", organizer_info="
				+ organizer_info + "]";
	}


}
