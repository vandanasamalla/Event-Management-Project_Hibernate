package com.hibernate.test;

import com.EventManagementProject.ServiceImpl.Venues_serviceipml;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.ParameterizedTest;
//import org.junit.jupiter.api.ValueSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
//import org.junit.jupiter.params.provider.CsvFileSource;

public class VenueserviceImplTest {
    
    Venues_serviceipml serv = new Venues_serviceipml();
    
    @ParameterizedTest
  
    @ValueSource(ints= {1500,1690,1000})
    void testcheckVenueCapacityException(int capacity) {
        int actual = serv.testcheckVenueCapacityException(capacity);
        Assertions.assertEquals(1, actual, "Capacity should be less than or equal to 1500");
    }
}

