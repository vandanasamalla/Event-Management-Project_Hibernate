package com.EventManagementProject.ServiceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.EventManagement.Entities.Events;
import com.EventManagement.Entities.Participants;
import com.EventManagement.Entities.Sponsorship;
import com.EventManagement.Entities.Tickets;
import com.EventManagementProject.Service.Sponsor_service;

public class Sponsor_serviceimpl implements Sponsor_service {
	  Scanner sc=new Scanner(System.in);
	  
	  Session session;

	@Override
	public void insertSponsor(SessionFactory sf) {
		  
			session = sf.openSession();
			Transaction tx = session.beginTransaction();

			Sponsorship ss = new Sponsorship();

			System.out.println("Welcome to Sponsorship");

			System.out.println("Enter Sponsorship Id: ");
			String ss_id = sc.nextLine();
		     ss.setSponsor_id(ss_id);

			System.out.println("Enter Sponsorship name:");
			String ss_name = sc.next();
			ss.setSponsor_name(ss_name);
			
			sc.nextLine();
			
			
			System.out.println("Enter Sponsor price:");
			int sp= sc.nextInt();
			ss.setSponsor_amount(sp);
			

			
			System.out.print("Enter Event id: ");
			int event_id = sc.nextInt();
			sc.nextLine();  

			Events evs = session.get(Events.class, event_id);
			if (evs == null) {
			    System.out.println("Event not found. Please enter a valid event ID.");
			    return;  
			}
		    ss.setEvent_id(evs);

	        
	        
			session.persist(ss);
			tx.commit();
			session.close();
			


			

		
	}

	@Override
	public void updateSponsor(SessionFactory sf) {
		
		session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
         Sponsorship sp;
		try {
			while (true) {
				System.out.println("Choose an Option for Update " + "\n1.Update sponsor_name\n2.Update sponsor_price\n3.update Event_id\n4.Exit");
				
	 
				int option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter Sponsor id :");
					sp= session.get(Sponsorship.class, sc.next());

					if (sp!= null) {
						System.out.println("Update Sponsorship name:");
						sp.setSponsor_name(sc.next());

						session.saveOrUpdate(sp);
						tx.commit();
						System.out.println("Sponsorship name updated successfully");
					} else {
						System.out.println("Sponsorship name not found for the given Id");
					}
					break;
				case 2:
					System.out.println("Enter Sponsorship id :");
					sp= session.get(Sponsorship.class, sc.next());

					if (sp!= null) {
						System.out.println("Update Sponsor price:");
						sp.setSponsor_amount(sc.nextInt());

						session.saveOrUpdate(sp);
						tx.commit();
						System.out.println(" sponsor price updated successfully");
					} else {
						System.out.println("sponsor price not found for the given Id");
					}
					break;

					
				case 3:
					System.out.println("Enter sponsor id:");
					sp= session.get(Sponsorship.class, sc.next());
					System.out.println("Update event id:");
                      int e_id=sc.nextInt();
                      Events e=session.get(Events.class, e_id);
                      
					if (e!= null) {
						sp.setEvent_id(e);
						session.saveOrUpdate(sp);
						tx.commit();
						System.out.println("event id updated successfully");
					} else {
						System.out.println("event id not found for the given Id");
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
	public void deleteSponsor(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter sponsor Id:");
		int id = sc.nextInt();

		Sponsorship ss = session.get(Sponsorship.class, id);
		try {
			if (ss!= null) {
				session.delete(ss);
				tx.commit();

			} else {
				System.out.println("Please Enter valid Sponsor Id");

			}
		} finally {
			session.close();

		}

		
	
	}

	@Override
	public void getAllSponsor(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		
			Query query = session.createQuery("from Sponsorship");
			List<Sponsorship> resultList = query.getResultList();

			for (Sponsorship c : resultList)
				System.out.println(c);
			tx.commit();
		
		session.close();

		
	}

	@Override
	public void getSponsor(SessionFactory sf) {
		session = sf.openSession();
		System.out.println("Enter Sponsor Id:");
		String id = sc.next();
		Sponsorship c = session.get(Sponsorship.class, id);
		System.out.println(c);
		session.close();

		
	}

	@Override
	public void getSponsorInformation(SessionFactory sf) {
		session = sf.openSession();

		Query query = session.createQuery("select count(sponsor_id) from Sponsorship");
		List<Integer> list = query.getResultList();

		System.out.println("Total number of Sponsors:" + list.get(0));
		session.close();

		
	} 

}
