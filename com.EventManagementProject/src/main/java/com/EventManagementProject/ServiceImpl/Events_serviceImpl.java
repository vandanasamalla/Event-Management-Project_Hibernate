package com.EventManagementProject.ServiceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.EventManagement.Entities.Events;
import com.EventManagement.Entities.Organizer;
import com.EventManagementProject.Service.Events_service;

public class Events_serviceImpl implements Events_service {
    private final Scanner sc = new Scanner(System.in);
    Session session;
	private int Event_id;
//=======================INSERT===========================================================
    @Override
    public void insertEvents(SessionFactory sf) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        try {
            Events ev = new Events();
            System.out.println("Welcome to Events");

            System.out.print("Enter Event Id: ");
            int event_id = sc.nextInt();
            ev.setEvent_id(event_id);
            sc.nextLine(); // Clear the newline character

            System.out.print("Enter Event name: ");
            String eventName = sc.nextLine();
            ev.setEvent_name(eventName);

            System.out.print("Enter Event Location: ");
            String location = sc.nextLine();
            ev.setLocation(location);

            System.out.print("Enter Organizer Id: ");
            int organizer_id = sc.nextInt();
            sc.nextLine(); // Clear the newline character

            // Attempt to retrieve Organizer by ID
            Organizer org = session.get(Organizer.class, organizer_id);
            if (org == null) {
                System.out.println("Organizer not found. Please enter a valid organizer ID.");
                return;  // Stop execution if Organizer is not found
            }
            ev.setOrganizer_id(org);  // Set Organizer only if it exists

            System.out.print("Enter event date (YYYY-MM-DD): ");
            String dateInput = sc.nextLine();
            try {
                LocalDate eventDate = LocalDate.parse(dateInput);
                ev.setDate(Date.valueOf(eventDate));  // Convert LocalDate to java.sql.Date
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD.");
                return;
            }
            // Persist only if all fields are correctly set
            session.persist(ev);
            tx.commit();
            System.out.println("Event inserted successfully!");

        } catch (Exception e) {
            if (tx != null) tx.rollback(); // Rollback in case of error
            e.printStackTrace();
        } finally {
            session.close(); // Ensure session is closed to prevent connection leak
        }
    }
    
    
    
    @Override
    public void updateEvents(SessionFactory sf) {
        session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Events ev;
        try {
            while (true) {
                System.out.println("Choose an Option for Update " + "\n1.Update event_Name\n2.Update date\n3. update Location\n4. update Organizer_id\n5.Exit");
                
                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input, please enter a number.");
                    sc.next(); // clear the invalid input
                    continue; // go back to the start of the loop
                }
                int option = sc.nextInt();
                sc.nextLine(); // Clear the newline character
                
                switch (option) {
                    case 1:
                        System.out.println("Enter Event Id:");
                        if (!sc.hasNextInt()) {
                            System.out.println("Invalid Event Id. Please enter a number.");
                            sc.next(); // clear invalid input
                            continue;
                        }
                        ev = session.get(Events.class, sc.nextInt());
                        sc.nextLine(); // Clear the newline character

                        if (ev != null) {
                            System.out.println("Update Event name:");
                            ev.setEvent_name(sc.nextLine());
                            session.saveOrUpdate(ev);
                            tx.commit();
                            System.out.println("Event name updated successfully");
                        } else {
                            System.out.println("Event not found for the given Id");
                        }
                        break;
                        
                        

                    case 2:
                        System.out.println("Enter Event Id:");
                        if (!sc.hasNextInt()) {
                            System.out.println("Invalid Event Id. Please enter a number.");
                            sc.next(); // clear invalid input
                            continue;
                        }
                        ev = session.get(Events.class, sc.nextInt());
                        sc.nextLine(); // Clear the newline character

                        if (ev != null) {
                            System.out.println("Update Event date:");
                            // Implement date input handling here as needed
                            // ...
                        } else {
                            System.out.println("Event not found for the given Id");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Event Id: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("Invalid Event Id. Please enter a number.");
                            sc.next();
                            continue;
                        }
                        Event_id = sc.nextInt();
                        sc.nextLine(); // Clear the newline character
                        ev = session.get(Events.class, Event_id);

                        if (ev != null) {
                            System.out.print("Update Event Location: ");
                            ev.setLocation(sc.next());
                            session.saveOrUpdate(ev);
                            tx.commit();
                            System.out.println("Event Location updated successfully.");
                        } else {
                            System.out.println("Event not found for the given Id.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Event Id: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("Invalid Event Id. Please enter a number.");
                            sc.next();
                            continue;
                        }
                        Event_id = sc.nextInt();
                        sc.nextLine(); // Clear the newline character
                        ev = session.get(Events.class, Event_id);
                        
                        if (ev != null) {
                            System.out.print("Update Organizer Id: ");
                            if (!sc.hasNextInt()) {
                                System.out.println("Invalid Organizer Id. Please enter a number.");
                                sc.next();
                                continue;
                            }
                            int organizer_id = sc.nextInt();
                            sc.nextLine(); // Clear the newline character
                            Organizer org = session.get(Organizer.class, organizer_id);
                            
                            if (org != null) {
                                ev.setOrganizer_id(org);
                                session.saveOrUpdate(ev);
                                tx.commit();
                                System.out.println("Organizer id updated successfully.");
                            } else {
                                System.out.println("Organizer not found for the given Id.");
                            }
                        } else {
                            System.out.println("Event not found for the given Id.");
                        }
                        break;


                    case 5:
                        System.out.println("Exiting...");
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
    public void deleteEvents(SessionFactory sf) {

    	session=sf.openSession();
    Transaction transaction=session.beginTransaction();
    
    System.out.println("Enter Event Id:");
    
    int id=sc.nextInt();
    Events event=session.get(Events.class, id);
    if(event!=null)
    	session.delete(event);
    else
    	System.out.println("Enter Valid Event Id!");
    transaction.commit();
    session.close();
    
    }
    @Override
    public void getAllEvents(SessionFactory sf) {
    	session = sf.openSession();
    	Transaction tx = session.beginTransaction();

    	
    		Query query = session.createQuery("from Events");
    		List<Events> resultList = query.getResultList();

    		for (Events c : resultList)
    			System.out.println(c);
    		tx.commit();
    	
    	session.close();

    }

    @Override
    public void getEvents(SessionFactory sf) {
		session = sf.openSession();
		System.out.println("Enter Event Id:");
		int id = sc.nextInt();
		Events c = session.get(Events.class, id);
		System.out.println(c);
		session.close();
    }

    @Override
    public void getEventsInformation(SessionFactory sf) {
		session = sf.openSession();

		Query query = session.createQuery("select count(event_id) from Events");
		List<Integer> list = query.getResultList();

		System.out.println("Total number of Events:" + list.get(0));
		session.close();
    }
}
