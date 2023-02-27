import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FlightTest {

    Flight flight;
    ArrayList<AirlineEmployee> crewComplement;
    Pilot pilot;
    Pilot firstOfficer;
    CabinCrew chiefPurser;
    CabinCrew attendant1;
    CabinCrew attendant2;
    ArrayList<Passenger> passengers;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;

    @Before
    public void before() {
        flight = new Flight("BA001", "TPE", "EDI", 1000, 1000, 2);
        crewComplement = new ArrayList<>();
        pilot = new Pilot("Amelia Earhart", Rank.CAPTAIN, "CPL12345");
        firstOfficer = new Pilot("Emily Howell Warner", Rank.FIRST_OFFICER, "CPL67890");
        chiefPurser = new CabinCrew("Big Jane", Rank.CHIEF_PURSER);
        attendant1 = new CabinCrew("Dee Reynolds", Rank.ATTENDANT);
        attendant2 = new CabinCrew("Ruby Richington", Rank.ATTENDANT);
        passengers = new ArrayList<>();
        passenger1 = new Passenger("Grace Kelly", 5);
        passenger2 = new Passenger("Cynthia Michaels", 2);
        passenger3 = new Passenger("Kate Mulgrew", 3);
    }

    @Test
    public void canGetCapacity(){
        assertEquals(2, flight.getCapacity());
    }

    @Test
    public void canReturnSeatsAvailable(){
        flight.addPassengerToFlight(passenger1);
        assertEquals(1, flight.getSeatsAvailable());
    }

    @Test
    public void planeStartsWithNoCrew(){
        assertEquals(0, flight.getCrewComplementSize());
    }

    @Test
    public void canAddAsPilot() {
        flight.addPilotToComplement(pilot);
        assertEquals(1, flight.getCrewComplementSize());
    }

    @Test
    public void cannotAddAsPilot(){
        try{
            flight.addPilotToComplement(attendant1);
            fail("Employee without sufficient rank has been added as a pilot");
        } catch(IllegalArgumentException noFlyLicense){
            assertEquals("The employee you are adding is not licensed to fly the plane", noFlyLicense.getMessage());
        }
    }

    @Test
    public void canAddCabinCrew(){
        flight.addCabinCrewMembers(chiefPurser);
        assertEquals(1, flight.getCrewComplementSize());
    }

    @Test
    public void shouldNotAddAsCabinCrew(){
        try{
            flight.addCabinCrewMembers(pilot);
        } catch (IllegalArgumentException error){
            assertEquals("This employee should be added to the Pilots list", error.getMessage());
        }
    }

    @Test
    public void canAddPassengers_SeatsAvailable(){
        flight.addPassengerToFlight(passenger3);
        flight.addPassengerToFlight(passenger2);
        assertEquals(2, flight.getPassengerListSize());
    }

    @Test
    public void cannotAddPassenger_NoSeatsAvailable(){
        flight.addPassengerToFlight(passenger1);
        flight.addPassengerToFlight(passenger2);
        flight.addPassengerToFlight(passenger3);
        assertEquals(2, flight.getPassengerListSize());
    }

    @Test
    public void planeCanFly(){
        flight.addPilotToComplement(pilot);
        flight.addCabinCrewMembers(attendant1);
        flight.addCabinCrewMembers(chiefPurser);
        flight.addPassengerToFlight(passenger3);
        assertEquals(true, flight.canFly());
    }

    @Test
    public void cannotFly_NoPilot(){
        flight.addCabinCrewMembers(attendant1);
        flight.addCabinCrewMembers(attendant2);
        assertEquals(false, flight.canFly());
    }

    @Test
    public void cannotFly_NoCrew(){
        flight.addPilotToComplement(pilot);
        flight.addPilotToComplement(firstOfficer);
        flight.addPassengerToFlight(passenger3);
        flight.addPassengerToFlight(passenger2);
        flight.addPassengerToFlight(passenger1);
        assertEquals(false, flight.canFly());
    }

    @Test
    public void canGetFlightNo(){
        assertEquals("BA001", flight.getFlightNo());
    }

    @Test
    public void canGetDestination(){
        assertEquals("TPE", flight.getDestination());
    }
    @Test
    public void canGetDepartureAirport(){
        assertEquals("EDI", flight.getDepartureAirport());
    }

    @Test
    public void canGetDepartureTime(){
        assertEquals(1000, flight.getDepartureTime());
    }

    @Test
    public void canGetWeightAllowance(){
        assertEquals(1000, flight.getWeightAllowance());
    }


//    @Test
//    public void canCreateFlightObjectWithCrewAndPassengers(){
//        assertEquals(Flight(), flight.createFlightWithCrewAndPassengers());
//    }




}




