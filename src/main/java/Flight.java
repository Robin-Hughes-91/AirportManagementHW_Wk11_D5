public class Flight {

    private Plane plane;
    private int flightNumber;
    private String destination;

    public Flight(int flightNumber, String destination){
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
    }

    public Plane getPlane() {
        return plane;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public int planeCapacity() {
        return this.plane.getPlaneType().getValue();
    }

    public int numberOfPassengersBooked() {
        return this.plane.getPassengers().size();
    }


}
