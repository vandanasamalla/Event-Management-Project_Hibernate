package com.EventManagement.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Event_participants {


	@Id
    private int event_participant_id;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participants participant;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Events event;

    // Default constructor
    public Event_participants() {
        super();
    }

    // Constructor with parameters
    public Event_participants(Participants participant, Events event) {
        this.participant = participant;
        this.event = event;
    }

    // Getters and Setters
    public int getEvent_participant_id() {
        return event_participant_id;
    }

    public void setEvent_participant_id(int event_participant_id) {
        this.event_participant_id = event_participant_id;
    }

    public Participants getParticipant() {
        return participant;
    }

    public void setParticipant(Participants participant) {
        this.participant = participant;
    }

    public Events getEvent() {
        return event;
    }

    public void setEvent(Events event) {
        this.event = event;
    }
    @Override
	public String toString() {
		return "Event_participants [event_participant_id=" + event_participant_id + ", participant=" + participant
				+ ", event=" + event + "]";
	}

}
