package com.EventManagementProject.Service;

import org.hibernate.SessionFactory;

public interface Event_participant_service {
	void insertEvent_participants(SessionFactory sf);
	void updateEvent_participants(SessionFactory sf);
	void deleteEvent_participants(SessionFactory sf);
	void getAllEvent_participants(SessionFactory sf);
	void getEvent_participants(SessionFactory sf);
	void getEvent_participantsInformation(SessionFactory sf);

}
