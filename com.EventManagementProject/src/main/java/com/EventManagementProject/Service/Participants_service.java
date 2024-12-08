package com.EventManagementProject.Service;

import org.hibernate.SessionFactory;

public interface Participants_service {
	void insertParticipants(SessionFactory sf);
	void updateParticipants(SessionFactory sf);
	void deleteParticipants(SessionFactory sf);
	void getAllParticipants(SessionFactory sf);
	void getParticipants(SessionFactory sf);
	void getParticipantsInformation(SessionFactory sf);


}
