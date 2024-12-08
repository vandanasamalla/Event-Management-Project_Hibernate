package com.EventManagementProject.Service;

import org.hibernate.SessionFactory;

import com.hibernate.utility.VenueCapacityException;

public interface Venues_service {	
void insertVenues(SessionFactory sf) throws VenueCapacityException;
void updateVenues(SessionFactory sf);
void deleteVenues(SessionFactory sf);
void getAllVenues(SessionFactory sf);
void getVenues(SessionFactory sf);
void getVenuesInformation(SessionFactory sf);


}
