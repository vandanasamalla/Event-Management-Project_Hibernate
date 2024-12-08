package com.EventManagementProject.Service;

import org.hibernate.SessionFactory;

public interface Sponsor_service {
	void insertSponsor(SessionFactory sf);
	void updateSponsor(SessionFactory sf);
	void deleteSponsor(SessionFactory sf);
	void getAllSponsor(SessionFactory sf);
	void getSponsor(SessionFactory sf);
	void getSponsorInformation(SessionFactory sf);

}
