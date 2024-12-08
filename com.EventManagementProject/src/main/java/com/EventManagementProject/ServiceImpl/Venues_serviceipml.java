package com.EventManagementProject.ServiceImpl;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.EventManagement.Entities.Events;
import com.EventManagement.Entities.Tickets;
import com.EventManagement.Entities.Venues;
import com.EventManagementProject.Service.Venues_service;
import com.hibernate.utility.VenueCapacityException;

public class Venues_serviceipml  implements Venues_service{
	  Scanner sc=new Scanner(System.in);
	  
	  Session session;


	@Override
	public void insertVenues(SessionFactory sf) throws VenueCapacityException {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

        Venues vn = new Venues();

		System.out.println("Welcome to Venues");

		System.out.println("Enter venue Id: ");
		int venue_id = sc.nextInt();
	     vn.setVenue_id(venue_id);

		System.out.println("Enter venue name:");
		String venue_name = sc.next();
		vn.setVenue_name(venue_name);
		
		sc.nextLine();
		
		
		System.out.println("Enter Address:");
		String address = sc.nextLine();
		vn.setAddress(address);
		
		System.out.println("Enter capacity: ");
		int capacity = sc.nextInt();
          
	     int Capacity=testcheckVenueCapacityException(capacity);
	     if(capacity==1500) {
	    	 throw new VenueCapacityException("we are sorry Hall is full");
	     }
	     vn.setCapacity(capacity);
		
        System.out.print("Enter event id: ");
        int event_id = sc.nextInt();
        sc.nextLine(); 
        
       Events ev= session.get(Events.class, event_id);
        if (ev == null) {
            System.out.println("Event not found. Please enter a valid event ID.");
            return;  
        }
        vn.setEvent_id(ev);


		session.persist(vn);
		tx.commit();
		session.close();

	}
        public int testcheckVenueCapacityException(int cap) {
        	if(cap>1500) {
        		return 0;
        	}else {
        		return 1;
        	}
        }

	@Override
	public void updateVenues(SessionFactory sf) {
		session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
		Venues v;
		try {
			while (true) {
				System.out.println("Choose an Option for Update " + "\n1.Update Venue_name\n2.Update Address\n3. Update capcity\n4.Event_id\n5.Exit");
	 
				int option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter Venues Id:");
					v = session.get(Venues.class, sc.nextInt());
					if (v!= null) {
						sc.nextLine();

						System.out.println("Update Venue name:");
						v.setVenue_name(sc.nextLine()  );

						session.saveOrUpdate(v);
						tx.commit();
						System.out.println("Venue name updated successfully");
					} else {
						System.out.println(" Venue name not found for the given Id");
					}
					break;
					
				case 2:
					System.out.println("Enter Venues Id:");
					v = session.get(Venues.class, sc.nextInt());
					if (v!= null) {
						System.out.println("Update Address:");
						v.setAddress(sc.nextLine());
						sc.nextLine();

						session.saveOrUpdate(v);
						tx.commit();
						System.out.println("Address updated successfully");
					} else {
						System.out.println("Address not found for the given Id");
					}
					break;
					
				case 3:
					System.out.println("Enter Venues Id:");
					v = session.get(Venues.class, sc.nextInt());
					if (v!= null) {
						sc.nextLine();

						System.out.println("Update Capacity:");
						v.setCapacity(sc.nextInt());


						session.saveOrUpdate(v);
						tx.commit();
						System.out.println("Capacity updated successfully");
					} else {
						System.out.println("Capacity not found for the given Id");
					}
					break;


					
				case 4:
					System.out.println("Enter venue Id:");
					v= session.get(Venues.class, sc.nextInt());
					System.out.println("Update Event id:");
                      int Venue_id=sc.nextInt();
                      Events ev=session.get(Events.class, Venue_id);
						sc.nextLine();

                      
					if (ev!= null) {
						v.setEvent_id(ev);
						session.saveOrUpdate(v);
						tx.commit();
						System.out.println("Event id updated successfully");
					} else {
						System.out.println("Event id not found for the given Id");
					}
					break;


				case 5:
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
	public void deleteVenues(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Enter Venue Id:");
		int id = sc.nextInt();

		Venues v = session.get(Venues.class, id);
		try {
			if (v!= null) {
				session.delete(v);
				tx.commit();

			} else {
				System.out.println("Please Enter valid Venue Id");

			}
		} finally {
			session.close();

		}

		
		
	}

	@Override
	public void getAllVenues(SessionFactory sf) {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();

		
			Query query = session.createQuery("from Venues");
			List<Venues> resultList = query.getResultList();

			for (Venues c : resultList)
				System.out.println(c);
			tx.commit();
		
		session.close();
		

	}

	@Override
	public void getVenues(SessionFactory sf) {
		session = sf.openSession();
		System.out.println("Enter Venue Id:");
		int id = sc.nextInt();
		Venues c = session.get(Venues.class, id);
		System.out.println(c);
		session.close();
		
	}

	@Override
	public void getVenuesInformation(SessionFactory sf) {
		session = sf.openSession();

		Query query = session.createQuery("select count(venue_id) from Venues");
		List<Integer> list = query.getResultList();

		System.out.println("Total number of Tickets:" + list.get(0));
		session.close();
		
	}

}
