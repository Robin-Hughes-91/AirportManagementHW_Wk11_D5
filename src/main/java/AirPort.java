import java.util.ArrayList;

public class AirPort {
    private String airportCode;
    private ArrayList<Plane> planes;
    private ArrayList<Flight> flights;

    public AirPort(String airportCode){
        this.airportCode = airportCode;
        this.planes = new ArrayList<Plane>();
        this.flights = new ArrayList<Flight>();
    }



    //GETTERS///////////////////////////////////////////////////////////////////


    public ArrayList<Plane> getPlanes() {
        return planes;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public int findPlaneCapacity(Flight flight){
        return flight.getPlane().getPlaneType().getValue();
    }

    public int howManyBookedOnFlight(Flight flight){
        return flight.getPlane().getPassengers().size();
    }

    //SETTERS/////////////////////////////////////////////////////////////////

    public void addPlane(Plane plane) {
        this.planes.add(plane);
    }

    public void createFlight(Flight flight) {
        this.flights.add(flight);
    }

    public void assignPlaneToFlight(int flightNumberToFind, Plane plane){
        for(Flight flight: flights){
            if(flightNumberToFind == flight.getFlightNumber()){
                flight.setPlane(plane);
            }
        }

    }

    public void addPassengerToFlight(Flight flight, Passenger passenger){
                flight.getPlane().addPassenger(passenger);

    }


    public void sellTicketToPassenger(int cost, Passenger passenger, AirPort airport, String destination){
        for(Flight flight: flights){
            if (destination == flight.getDestination()){
                if (flight.numberOfPassengersBooked() < flight.planeCapacity()  && passenger.getWallet() >= cost){
                    passenger.payMoney(cost);
                    airport.addPassengerToFlight(flight, passenger);
                }
            }
        }
    }




}
