import java.util.ArrayList;

public class Plane {
    private PlaneType planeType ;
    private String airline;
    private ArrayList<Passenger> passengers;

    public Plane(PlaneType plane, String airline){
        this.planeType = plane;
        this.airline = airline;
        this.passengers = new ArrayList<Passenger>();
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public String getAirline() {
        return airline;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger){
        this.passengers.add(passenger);

    }
}
