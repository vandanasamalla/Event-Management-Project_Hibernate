package com.EventManagementProject.Service;

import org.hibernate.SessionFactory;

public interface Ticket_service {
	void insertTickets(SessionFactory sf);
	void updateTickets(SessionFactory sf);
	void deleteTickets(SessionFactory sf);
	void getAllTickets(SessionFactory sf);
	void getTickets(SessionFactory sf);
	void getTicketsInformation(SessionFactory sf);

}
