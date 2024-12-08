package com.EventManagementProject.Service;

import org.hibernate.SessionFactory;

public interface Events_service {		
    void insertEvents(SessionFactory sf);
    void updateEvents(SessionFactory sf);
    void deleteEvents(SessionFactory sf);
    void getAllEvents(SessionFactory sf);
    void getEvents(SessionFactory sf);
    void getEventsInformation(SessionFactory sf);


}
