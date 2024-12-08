package com.EventManagementProject.ServiceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.EventManagement.Entities.Events;
import com.EventManagement.Entities.Organizer;
import com.EventManagement.Entities.Tickets;
import com.EventManagementProject.Service.Ticket_service;

public class Ticket_serviceimpl implements Ticket_service{
	  Scanner sc=new Scanner(System.in);
	  
	  Session session;

	

	@Override
	public void insertTickets(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Tickets t = new Tickets();

		System.out.println("Welcome to Tickets");

		System.out.println("Enter ticket Id: ");
		int ticket_id = sc.nextInt();
	     t.setTicket_id(ticket_id);

		System.out.println("Enter ticket price:");
		int ticket_price = sc.nextInt();
		t.setTicket_price(ticket_price);
		
        System.out.print("Enter Event Id: ");
        int event_id = sc.nextInt();
        sc.nextLine(); 
        
       Events ev= session.get(Events.class, event_id);
        if (ev == null) {
            System.out.println("Event not found. Please enter a valid event ID.");
            return;  
        }
        t.setEvent_id(ev);


		session.persist(t);
		tx.commit();
		session.close();
		
	}

	@Override
	public void updateTickets(SessionFactory sf) {
		session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
		Tickets t;
		try {
			while (true) {
				System.out.println("Choose an Option for Update " + "\n1.Update Ticket_price\n2.Update Event_id\n3.Exit");
	 
				int option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter Ticket Id:");
					t = session.get(Tickets.class, sc.nextInt());

					if (t!= null) {
						System.out.println("Update Ticket price:");
						t.setTicket_price(sc.nextInt() );

						session.saveOrUpdate(t);
						tx.commit();
						System.out.println("Ticket price updated successfully");
					} else {
						System.out.println("Ticket price not found for the given Id");
					}
					break;
					
				case 2:
					System.out.println("Enter ticket Id:");
					t= session.get(Tickets.class, sc.nextInt());
					System.out.println("Update Event id:");
                      int Ticket_id=sc.nextInt();
                      Events ev=session.get(Events.class, Ticket_id);
                      
					if (ev!= null) {
						t.setEvent_id(ev);
						session.saveOrUpdate(t);
						tx.commit();
						System.out.println("Event id updated successfully");
					} else {
						System.out.println("Event id not found for the given Id");
					}
					break;


				case 3:
					System.out.println("Exit");
					System.exit(0);
					break;

				default:
					System.out.println("Choose correct option!!");
				}
			}
		} finally {
			session.close();
		}

     		
	}

	@Override
	public void deleteTickets(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Ticket Id:");
		int id = sc.nextInt();

		Tickets t = session.get(Tickets.class, id);
		try {
			if (t != null) {
				session.delete(t);
				tx.commit();

			} else {
				System.out.println("Please Enter valid Ticket Id");

			}
		} finally {
			session.close();

		}

		
	}

	@Override
	public void getAllTickets(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		
			Query query = session.createQuery("from Tickets");
			List<Tickets> resultList = query.getResultList();

			for (Tickets c : resultList)
				System.out.println(c);
			tx.commit();
		
		session.close();
		
	}

	@Override
	public void getTickets(SessionFactory sf) {
		session = sf.openSession();
		System.out.println("Enter Tickets Id:");
		int id = sc.nextInt();
		Tickets c = session.get(Tickets.class, id);
		System.out.println(c);
		session.close();

		
	}

	@Override
	public void getTicketsInformation(SessionFactory sf) {
		session = sf.openSession();

		Query query = session.createQuery("select count(Ticket_id) from Tickets");
		List<Integer> list = query.getResultList();

		System.out.println("Total number of Tickets:" + list.get(0));
		session.close();
		
	}


}
