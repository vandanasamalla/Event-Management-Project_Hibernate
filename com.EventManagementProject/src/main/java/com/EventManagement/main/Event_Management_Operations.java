package com.EventManagement.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.EventManagement.Entities.Event_participants;
import com.EventManagement.Entities.Events;
import com.EventManagement.Entities.Organizer;
import com.EventManagement.Entities.Participants;
import com.EventManagement.Entities.Sponsorship;
import com.EventManagement.Entities.Tickets;
import com.EventManagement.Entities.Venues;
import com.EventManagementProject.ServiceImpl.Event_participant_serviceimpl;
import com.EventManagementProject.ServiceImpl.Events_serviceImpl;
import com.EventManagementProject.ServiceImpl.Organizer_Serviceimpl;
import com.EventManagementProject.ServiceImpl.Participants_serviceimpl;
import com.EventManagementProject.ServiceImpl.Sponsor_serviceimpl;
import com.EventManagementProject.ServiceImpl.Ticket_serviceimpl;
import com.EventManagementProject.ServiceImpl.Venues_serviceipml;
//import com.EventManagement.utility.ConfigurationUtility;
import com.hibernate.utility.VenueCapacityException;

public class Event_Management_Operations {

    public static void main(String[] args) throws VenueCapacityException {
    	Configuration cf=new Configuration();
    	cf.configure("config.xml");
        SessionFactory factory = cf.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Scanner sc = new Scanner(System.in);

        boolean isRunning = true;
        try {
            while (isRunning) {
                System.out.println("---- Welcome to Event Management Application ----");
                System.out.println("Select an option:\n1. Organizer\n2. Events\n3. Tickets\n4. Venues\n5. Participants\n6. Sponsors\n7. Event Participants\n8. Exit");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        manageOrganizer(sc, factory);
                        break;
                    case 2:
                        manageEvents(sc, factory);
                        break;
                    case 3:
                        manageTickets(sc, factory);
                        break;
                    case 4:
                        manageVenues(sc, factory);
                        break;
                    case 5:
                        manageParticipants(sc, factory);
                        break;
                    case 6:
                        manageSponsors(sc, factory);
                        break;
                   // case 7:
                     //   manageEventParticipants(sc, factory);
                       // break;
                    case 8:
                        isRunning = false;
                        System.out.println("Exiting the application.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } finally {
            sc.close();
            session.close();
            factory.close();
        }
    }

    // Organizer Management
    private static void manageOrganizer(Scanner sc, SessionFactory factory) {
        Organizer_Serviceimpl orgService = new Organizer_Serviceimpl();
        while (true) {
            System.out.println("Organizer Management:\n1. Insert\n2. Update\n3. Delete\n4. Get All\n5. Get Specific\n6. Count\n7. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    orgService.insertOrganizer(factory);
                    break;
                case 2:
                    orgService.updateOrganizer(factory);
                    break;
                case 3:
                    orgService.deleteOrganizer(factory);
                    break;
                case 4:
                    orgService.getAllOrganizer(factory);
                    break;
                case 5:
                    orgService.getOrganizer(factory);
                    break;
                case 6:
                    orgService.getOrganizerInformation(factory);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Event Management
    private static void manageEvents(Scanner sc, SessionFactory factory) {
        Events_serviceImpl eventService = new Events_serviceImpl();
        while (true) {
            System.out.println("Event Management:\n1. Insert\n2. Update\n3. Delete\n4. Get All\n5. Get Specific\n6. Count\n7. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    eventService.insertEvents(factory);
                    break;
                case 2:
                    eventService.updateEvents(factory);
                    break;
                case 3:
                    eventService.deleteEvents(factory);
                    break;
                case 4:
                    eventService.getAllEvents(factory);
                    break;
                case 5:
                    eventService.getEvents(factory);
                    break;
                case 6:
                    eventService.getEventsInformation(factory);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Ticket Management
    private static void manageTickets(Scanner sc, SessionFactory factory) {
        Ticket_serviceimpl ticketService = new Ticket_serviceimpl();
        while (true) {
            System.out.println("Ticket Management:\n1. Insert\n2. Update\n3. Delete\n4. Get All\n5. Get Specific\n6. Count\n7. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    ticketService.insertTickets(factory);
                    break;
                case 2:
                    ticketService.updateTickets(factory);
                    break;
                case 3:
                    ticketService.deleteTickets(factory);
                    break;
                case 4:
                    ticketService.getAllTickets(factory);
                    break;
                case 5:
                    ticketService.getTickets(factory);
                    break;
                case 6:
                    ticketService.getTicketsInformation(factory);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Venue Management
    private static void manageVenues(Scanner sc, SessionFactory factory) throws VenueCapacityException {
        Venues_serviceipml venueService = new Venues_serviceipml();
        while (true) {
            System.out.println("Venue Management:\n1. Insert\n2. Update\n3. Delete\n4. Get All\n5. Get Specific\n6. Count\n7. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    venueService.insertVenues(factory);
                    break;
                case 2:
                    venueService.updateVenues(factory);
                    break;
                case 3:
                    venueService.deleteVenues(factory);
                    break;
                case 4:
                    venueService.getAllVenues(factory);
                    break;
                case 5:
                    venueService.getVenues(factory);
                    break;
                case 6:
                    venueService.getVenuesInformation(factory);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Participant Management
    private static void manageParticipants(Scanner sc, SessionFactory factory) {
        Participants_serviceimpl participantService = new Participants_serviceimpl();
        while (true) {
            System.out.println("Participant Management:\n1. Insert\n2. Update\n3. Delete\n4. Get All\n5. Get Specific\n6. Count\n7. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    participantService.insertParticipants(factory);
                    break;
                case 2:
                    participantService.updateParticipants(factory);
                    break;
                case 3:
                    participantService.deleteParticipants(factory);
                    break;
                case 4:
                    participantService.getAllParticipants(factory);
                    break;
                case 5:
                    participantService.getParticipants(factory);
                    break;
                case 6:
                    participantService.getParticipantsInformation(factory);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Sponsor Management
    private static void manageSponsors(Scanner sc, SessionFactory factory) {
        Sponsor_serviceimpl sponsorService = new Sponsor_serviceimpl();
        while (true) {
            System.out.println("Sponsor Management:\n1. Insert\n2. Update\n3. Delete\n4. Get All\n5. Get Specific\n6. Count\n7. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    sponsorService.insertSponsor(factory);
                    break;
                case 2:
                    sponsorService.updateSponsor(factory);
                    break;
                case 3:
                    sponsorService.deleteSponsor(factory);
                    break;
                case 4:
                    sponsorService.getAllSponsor(factory);
                    break;
                case 5:
                    sponsorService.getSponsor(factory);
                    break;
                case 6:
                    sponsorService.getSponsorInformation(factory);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Event Participant Management
    /*private static void manageEventParticipants(Scanner sc, SessionFactory factory) {
        Event_participant_serviceimpl eventParticipantService = new Event_participant_serviceimpl();
        while (true) {
            System.out.println("Event Participant Management:\n1. Insert\n2. Update\n3. Delete\n4. Get All\n5. Get Specific\n6. Count\n7. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    eventParticipantService.insertEvent_participants(factory);
                    break;
                case 2:
                    eventParticipantService.updateEvent_participants(factory);
                    break;
                case 3:
                    eventParticipantService.deleteEvent_participants(factory);
                    break;
                case 4:
                    eventParticipantService.getAllEvent_participants(factory);
                    break;
                case 5:
                    eventParticipantService.getEvent_participants(factory);
                    break;
                case 6:
                    eventParticipantService.getEvent_participantsInformation(factory);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }*/
}
