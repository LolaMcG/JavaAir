import java.util.ArrayList;

public class Flight {

    private ArrayList<AirlineEmployee> crewComplement;
    private ArrayList<Passenger> passengers;
    private String flightNo;
    private String destination;
    private String departureAirport;
    private int departureTime;
    private int weightAllowance;
    private int capacity;

    public Flight(String flightNo, String destination, String departureAirport, int departureTime, int weightAllowance, int capacity){
        this.crewComplement = new ArrayList<AirlineEmployee>();
        this.passengers = new ArrayList<Passenger>();
        this.flightNo = flightNo;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.weightAllowance = weightAllowance;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSeatsAvailable(){
        return capacity - getPassengerListSize();
    }

    public int getCrewComplementSize() {
        return this.crewComplement.size();
    }

//    Should only be able to add AirlineEmployees that are Pilots
    public void addPilotToComplement(AirlineEmployee employee){
//        If the employee is a Pilot
        if (employee instanceof Pilot) {
//            add the employee
            this.crewComplement.add(employee);
        } else {
//            If the employee is not a Pilot they cannot be added as pilot
            throw new IllegalArgumentException("The employee you are adding is not licensed to fly the plane");
        }
    }

    public void addCabinCrewMembers(AirlineEmployee employee) {
        if (employee instanceof CabinCrew){
            this.crewComplement.add(employee);
        } else {
            throw new IllegalArgumentException("This employee should be added to the Pilots list");
        }
    }

    public int getPassengerListSize(){
        return this.passengers.size();
    }

    public void addPassengerToFlight(Passenger passenger){
        if (getPassengerListSize() < this.capacity)
        passengers.add(passenger);
    }

    public boolean canFly(){
//        set default values to false
        boolean hasPilot = false;
        boolean hasCrew = false;
        boolean spaceForPassengers = false;
        if (getPassengerListSize() <= getCapacity())
            spaceForPassengers = true;
//        for (class_name variable_name : list_to_iterate_over)
        for (AirlineEmployee employee : crewComplement){
//            if there's a pilot, then hasPilot is now true
            if(employee instanceof Pilot){
                hasPilot = true;
//            if there's a cabin crew member, hasCrew is now true
            } else if (employee instanceof CabinCrew){
                hasCrew = true;
            }
//        plane should only be able to fly if there is at least one pilot, one member of cabin crew, and enough space for passengers
            if (hasPilot && hasCrew && spaceForPassengers){
                return true;
            }
            }
        return false;
        }

    public String getFlightNo(){
            return this.flightNo;
        }

    public String getDestination() {
        return this.destination;
    }

    public String getDepartureAirport(){
        return this.departureAirport;
    }

    public int getDepartureTime(){
        return this.departureTime;
    }

    public int getWeightAllowance(){
        return this.weightAllowance;
    }


//    public static Flight createFlightWithCrewAndPassengers(ArrayList crewComplement, ArrayList passengers){
//
//    }
    }