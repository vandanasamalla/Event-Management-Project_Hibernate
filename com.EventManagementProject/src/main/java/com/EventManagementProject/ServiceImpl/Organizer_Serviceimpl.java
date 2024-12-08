package com.EventManagementProject.ServiceImpl;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.EventManagement.Entities.Organizer;           
import com.EventManagementProject.Service.Organizer_Service;

public class Organizer_Serviceimpl implements Organizer_Service {
  Scanner sc=new Scanner(System.in);
  
  Session session;
  
@Override
public void insertOrganizer(SessionFactory sf) {
	session = sf.openSession();
	Transaction tx = session.beginTransaction();

	Organizer org = new Organizer();

	System.out.println("Welcome to Organizer");

	System.out.println("Enter Organizer Id: ");
	int id = sc.nextInt();
	org.setOrganizer_id(id);

	System.out.println("Enter Organizer name:");
	String Organizer_name = sc.next();
	org.setOrganizer_name(Organizer_name);
	
	System.out.println("Enter Organizer info:");
    String Organizer_info=sc.next();
	org.setOrganizer_info(Organizer_info);

	session.persist(org);
	tx.commit();
	session.close();
}
@Override 
public void updateOrganizer(SessionFactory sf) {
	session=sf.openSession();
	Transaction tx=session.beginTransaction();
	
	Organizer org;
	try {
		while (true) {
			System.out.println("Choose an Option for Update " + "\n1.Update Organizer_Name\n2.Update Organizer_info\n3.Exit");
 
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter Organizer Id:");
				org = session.get(Organizer.class, sc.nextInt());

				if (org!= null) {
					System.out.println("Update Organizer name:");
					org.setOrganizer_name(sc.next());

					session.saveOrUpdate(org);
					tx.commit();
					System.out.println("Organizer info updated successfully");
				} else {
					System.out.println("Organizer not found for the given Id");
				}
				break;
				
			case 2:
				System.out.println("Enter Organizer Id:");
				org = session.get(Organizer.class, sc.nextInt());

				if (org!= null) {
					System.out.println("Update Organizer info:");
					org.setOrganizer_info(sc.next());

					session.saveOrUpdate(org);
					tx.commit();
					System.out.println("Organizer info updated successfully");
				} else {
					System.out.println("Organizer not found for the given Id");
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
	} catch (Exception e) {
	    if (tx != null) tx.rollback(); // Rollback in case of an exception
	    e.printStackTrace();
	}
}

@Override
public void deleteOrganizer(SessionFactory sf) {
	session = sf.openSession();
	Transaction tx = session.beginTransaction();

	System.out.println("Enter Organizer Id:");
	int id = sc.nextInt();

	Organizer org = session.get(Organizer.class, id);
	try {
		if (org != null) {
			session.delete(org);
			tx.commit();

		} else {
			System.out.println("Please Enter valid Organizer Id");

		}
	} finally {
		session.close();

	}

}

@Override
public void getAllOrganizer(SessionFactory sf) {
	session = sf.openSession();
	Transaction tx = session.beginTransaction();

	
		Query query = session.createQuery("from Organizer");
		List<Organizer> resultList = query.getResultList();

		for (Organizer c : resultList)
			System.out.println(c);
		tx.commit();
	
	session.close();
   }

@Override
	// Select a specific category "record"

	public void getOrganizer(SessionFactory sf) {

		session = sf.openSession();
		System.out.println("Enter Organizer Id:");
		int id = sc.nextInt();
		Organizer c = session.get(Organizer.class, id);
		System.out.println(c);
		session.close();

		
	
	 
}

@Override
//Overall "count" of category records
	public void getOrganizerInformation(SessionFactory sf) {

		session = sf.openSession();

		Query query = session.createQuery("select count(organizer_id) from Organizer");
		List<Integer> list = query.getResultList();

		System.out.println("Total number of Organizers:" + list.get(0));
		session.close();

	}

}
