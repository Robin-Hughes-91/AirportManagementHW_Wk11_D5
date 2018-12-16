import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAirPort {

    AirPort airport;
    Plane plane;
    Plane plane2;

    Flight flight;
    Flight flight2;

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
        plane2 = new Plane(PlaneType.BOEING740, "RyanAir");



        flight = new Flight(777, "Berlin");
        flight2 = new Flight(778, "London");

        airport = new AirPort("_GLA_");
        airport.addPlane(plane);
        airport.addPlane(plane2);

        airport.createFlight(flight);
        airport.createFlight(flight2);

        airport.assignPlaneToFlight(777, plane);
        airport.assignPlaneToFlight(778, plane2);



        airport.sellTicketToPassenger(90, passenger2, airport, "Berlin" );
        airport.sellTicketToPassenger(90, passenger3, airport, "Berlin" );
        airport.sellTicketToPassenger(10, passenger3, airport, "London" );
        airport.sellTicketToPassenger(110, passenger4, airport, "Berlin" );
        airport.sellTicketToPassenger(90, passenger4, airport, "London" );

    }

    @Test
    public void testGetPlanes() {
        assertEquals(2, airport.getPlanes().size());
    }

    @Test
    public void testGetAirPortCode() {
        assertEquals("_GLA_", airport.getAirportCode());
    }

    @Test
    public void testCreateFlight() {
        assertEquals(2, airport.getFlights().size());
    }

    @Test
    public void testFindPlaneCapacity() {
        airport.assignPlaneToFlight(777, plane);
        assertEquals(4, airport.findPlaneCapacity(flight) );

    }

    @Test
    public void testAssignPlaneToFlight() {
        airport.assignPlaneToFlight(777, plane);
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void testAddPassengerToFlight() {
        airport.addPassengerToFlight(flight, passenger);
        assertEquals(3, flight.getPlane().getPassengers().size());
    }

    @Test
    public void testSellTicketToPassenger() {

        airport.sellTicketToPassenger(110, passenger, airport, "Berlin" );

        assertEquals(10, passenger2.getWallet());
        assertEquals(4, airport.findPlaneCapacity(flight) );
        assertEquals(2, airport.howManyBookedOnFlight(flight));
        assertEquals(1, airport.howManyBookedOnFlight(flight2));




    }

    @Test
    public void testHowManyBookedOnFlight() {
        assertEquals(2, airport.howManyBookedOnFlight(flight));

    }
}
