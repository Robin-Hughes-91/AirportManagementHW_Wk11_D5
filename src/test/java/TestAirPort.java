import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAirPort {

    AirPort airport;
    Plane plane;
    Flight flight;
    Passenger passenger;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;


    @Before
    public void before(){
        passenger = new Passenger("Robin", 100);
        passenger2 = new Passenger("Robin", 100);
        passenger3= new Passenger("Robin", 100);
        passenger4 = new Passenger("Robin", 100);

        plane = new Plane(PlaneType.BOEING747, "RyanAir");
        flight = new Flight(777, "Berlin");
        airport = new AirPort("_GLA_");
        airport.addPlane(plane);
        airport.createFlight(flight);
        airport.assignPlaneToFlight(777, plane);


        airport.sellTicketToPassenger(90, passenger2, airport, "Berlin" );
        airport.sellTicketToPassenger(90, passenger3, airport, "Berlin" );
        airport.sellTicketToPassenger(90, passenger4, airport, "Berlin" );
    }

    @Test
    public void testGetPlanes() {
        assertEquals(1, airport.getPlanes().size());
    }

    @Test
    public void testGetAirPortCode() {
        assertEquals("_GLA_", airport.getAirportCode());
    }

    @Test
    public void testCreateFlight() {
        assertEquals(1, airport.getFlights().size());
    }

    @Test
    public void testFindPlaneCapacity() {
        airport.assignPlaneToFlight(777, plane);
        assertEquals(3, airport.findPlaneCapacity(flight) );

    }

    @Test
    public void testAssignPlaneToFlight() {
        airport.assignPlaneToFlight(777, plane);
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void testAddPassengerToFlight() {
        airport.addPassengerToFlight(flight, passenger);
        assertEquals(4, flight.getPlane().getPassengers().size());
    }

    @Test
    public void testSellTicketToPassenger() {

        airport.sellTicketToPassenger(90, passenger, airport, "Berlin" );

        assertEquals(10, passenger.getWallet());
        assertEquals(3, airport.findPlaneCapacity(flight) );
        assertEquals(3, airport.howManyBookedOnFlight(flight));



    }

    @Test
    public void testHowManyBookedOnFlight() {
        assertEquals(3, airport.howManyBookedOnFlight(flight));

    }
}
