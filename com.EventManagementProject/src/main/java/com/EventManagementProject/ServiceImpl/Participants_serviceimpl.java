package com.EventManagementProject.ServiceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.EventManagement.Entities.Events;
import com.EventManagement.Entities.Participants;
import com.EventManagement.Entities.Tickets;
import com.EventManagement.Entities.Venues;
import com.EventManagementProject.Service.Participants_service;

public class Participants_serviceimpl implements Participants_service{
	  Scanner sc=new Scanner(System.in);
	  
	  Session session;


	@Override
	public void insertParticipants(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

        Participants pr = new Participants();

		System.out.println("Welcome to Participants");

		System.out.println("Enter Participants Id: ");
		int pr_id = sc.nextInt();
	     pr.setParticipant_id(pr_id);

		System.out.println("Enter Participants name:");
		String pr_name = sc.next();
		pr.setParticipant_name(pr_name);
		
		sc.nextLine();
		
		
		System.out.println("Enter Contact_info:");
		String c_info = sc.nextLine();
		pr.setContact_info(c_info);
		

		
        System.out.print("Enter Ticket id: ");
        int Ticket_id = sc.nextInt();
        sc.nextLine(); 
        
       Tickets t= session.get(Tickets.class, Ticket_id);
        if (t==null) {
               System.out.println("Event not found. Please enter a valid event ID.");
            return;  
        }
        pr.setTicket_id(t);
        
        
		session.persist(pr);
		tx.commit();
		session.close();
		
  

		
	}

	@Override
	public void updateParticipants(SessionFactory sf) {
		session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
         Participants p;
		try {
			while (true) {
				System.out.println("Choose an Option for Update " + "\n1.Update participants_name\n2.Update contact_info\n3.Ticket_id\n4.Exit");
				
	 
				int option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter Participant id :");
					p= session.get(Participants.class, sc.nextInt());

					if (p!= null) {
						System.out.println("Update participant name:");
						p.setParticipant_name(sc.next());

						session.saveOrUpdate(p);
						tx.commit();
						System.out.println("participant name updated successfully");
					} else {
						System.out.println("participant name not found for the given Id");
					}
					break;
				case 2:
					System.out.println("Enter Participant id :");
					p= session.get(Participants.class, sc.nextInt());

					if (p!= null) {
						System.out.println("Update contact info:");
						p.setContact_info(sc.next());

						session.saveOrUpdate(p);
						tx.commit();
						System.out.println("contact info updated successfully");
					} else {
						System.out.println("contact info not found for the given Id");
					}
					break;

					
				case 3:
					System.out.println("Enter participant id:");
					p= session.get(Participants.class, sc.nextInt());
					System.out.println("Update Ticket id:");
                      int ticket_id=sc.nextInt();
                      Tickets t=session.get(Tickets.class, ticket_id);
                      
					if (t!= null) {
						p.setTicket_id(t);
						session.saveOrUpdate(p);
						tx.commit();
						System.out.println("Ticket id updated successfully");
					} else {
						System.out.println("Ticket id not found for the given Id");
					}
					break;


				case 4:
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
	public void deleteParticipants(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter participant Id:");
		int id = sc.nextInt();

		Participants p = session.get(Participants.class, id);
		try {
			if (p!= null) {
				session.delete(p);
				tx.commit();

			} else {
				System.out.println("Please Enter valid Participant Id");

			}
		} finally {
			session.close();

		}

		
		
		
	}

	@Override
	public void getAllParticipants(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		
			Query query = session.createQuery("from Participants");
			List<Participants> resultList = query.getResultList();

			for (Participants c : resultList)
				System.out.println(c);
			tx.commit();
		
		session.close();

	}

	@Override
	public void getParticipants(SessionFactory sf) {
		session = sf.openSession();
		System.out.println("Enter Participant Id:");
		int id = sc.nextInt();
		Participants c = session.get(Participants.class, id);
		System.out.println(c);
		session.close();
		
	}

	@Override
	public void getParticipantsInformation(SessionFactory sf) {
		session = sf.openSession();

		Query query = session.createQuery("select count(participant_id) from Participants");
		List<Integer> list = query.getResultList();

		System.out.println("Total number of Tickets:" + list.get(0));
		session.close();

		
	}

}
