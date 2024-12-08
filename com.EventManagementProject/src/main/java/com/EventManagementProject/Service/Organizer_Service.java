package com.EventManagementProject.Service;

import org.hibernate.SessionFactory;

public interface Organizer_Service {

		void insertOrganizer(SessionFactory sf);
		void updateOrganizer(SessionFactory sf);
		void deleteOrganizer(SessionFactory sf);
		void getAllOrganizer(SessionFactory sf);
		void getOrganizer(SessionFactory sf);
		void getOrganizerInformation(SessionFactory sf);
		
	}







