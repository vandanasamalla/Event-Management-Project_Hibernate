package com.EventManagementProject.ServiceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.EventManagement.Entities.Event_participants;
import com.EventManagement.Entities.Events;
import com.EventManagement.Entities.Participants;
import com.EventManagement.Entities.Tickets;
import com.EventManagementProject.Service.Event_participant_service;

public class Event_participant_serviceimpl implements Event_participant_service {
	  Scanner sc=new Scanner(System.in);
	  
	  Session session;


	@Override
	public void insertEvent_participants(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Event_participants pr = new Event_participants();

		System.out.println("Welcome to Event_articipants");

		System.out.println("Enter Event_participants Id: ");
		int Evpr_id= sc.nextInt();
	     pr.setEvent_participant_id(Evpr_id);




		
        System.out.print("Enter participant id: ");
        int pr_id = sc.nextInt();
        sc.nextLine(); 
        
        Participants par= session.get(Participants.class, pr_id);
        if (par==null) {
               System.out.println("Participant not found. Please enter a valid event ID.");
              return;  
        }
        pr.setParticipant(par);
        
        
        System.out.print("Enter Event id: ");
        int e_id = sc.nextInt();
        sc.nextLine(); 
        
        Events et= session.get(Events.class, e_id);
        if (et==null) {
               System.out.println("Event not found. Please enter a valid event ID.");
              return;  
        }
        pr.setEvent(et);
        
		session.persist(pr);
		tx.commit();
		session.close();
	
	}

	@Override
	public void updateEvent_participants(SessionFactory sf) {
		session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
         Event_participants ep;
		try {
			while (true) {
				System.out.println("Choose an Option for Update " + "\n1.Update Participant_id\n2.Update event_id\n3.Exit");
				
	 
				int option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter  Event participant id:");
					ep= session.get(Event_participants.class, sc.nextInt());
					System.out.println("Update Participant id:");
                      int pr_id=sc.nextInt();
                      Participants pr=session.get(Participants.class, pr_id);
                      
					if (pr!= null) {
						ep.setParticipant(pr);
						session.saveOrUpdate(ep);
						tx.commit();
						System.out.println("Ticket id updated successfully");
					} else {
						System.out.println("Ticket id not found for the given Id");
					}
					break;


					
				case 2:
					System.out.println("Enter  Event participant id:");
					ep= session.get(Event_participants.class, sc.nextInt());
					System.out.println("Update Event id:");
                      int e_id=sc.nextInt();
                      Events e=session.get(Events.class, e_id);
                      
					if (e!= null) {
						ep.setEvent(e);
						session.saveOrUpdate(ep);
						tx.commit();
						System.out.println("Ticket id updated successfully");
					} else {
						System.out.println("Ticket id not found for the given Id");
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
	public void deleteEvent_participants(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Event_participant Id:");
		int id = sc.nextInt();

		Event_participants ep = session.get(Event_participants.class, id);
		try {
			if (ep!= null) {
				session.delete(ep);
				tx.commit();

			} else {
				System.out.println("Please Enter valid Event_SParticipant Id");

			}
		} finally {
			session.close();

		}

		
		
		

	}

	@Override
	public void getAllEvent_participants(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		
			Query query = session.createQuery("from Event_participants");
			List<Event_participants> resultList = query.getResultList();

			for (Event_participants c : resultList)
				System.out.println(c);
			tx.commit();
		
		session.close();

		
	}

	@Override
	public void getEvent_participants(SessionFactory sf) {
		session = sf.openSession();
		System.out.println("Enter Event Participant Id:");
		int id = sc.nextInt();
		Event_participants c = session.get(Event_participants.class, id);
		System.out.println(c);
		session.close();
		
	}

	@Override
	public void getEvent_participantsInformation(SessionFactory sf) {
		session = sf.openSession();

		Query query = session.createQuery("select count(event_participant_id) from Event_participants");
		List<Integer> list = query.getResultList();

		System.out.println("Total number of Tickets:" + list.get(0));
		session.close();
		
	}

}
