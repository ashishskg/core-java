package ai.design.pattern.behaviral.mediator.airtrafficexam;

import java.util.ArrayList;
import java.util.List;

// Mediator interface
interface AirTrafficControl {
    void registerAircraft(Aircraft aircraft);
    void sendWarning(Aircraft aircraft, String warning);
    void sendClearance(Aircraft aircraft, String clearance);
}

// Concrete mediator class
class AirTrafficControlImpl implements AirTrafficControl {
    private List<Aircraft> aircraftList;

    public AirTrafficControlImpl() {
        this.aircraftList = new ArrayList<>();
    }

    public void registerAircraft(Aircraft aircraft) {
        aircraftList.add(aircraft);
    }

    public void sendWarning(Aircraft aircraft, String warning) {
        System.out.println("[ATC] Warning issued to aircraft " + aircraft.getFlightNumber() + ": " + warning);
    }

    public void sendClearance(Aircraft aircraft, String clearance) {
        System.out.println("[ATC] Clearance issued to aircraft " + aircraft.getFlightNumber() + ": " + clearance);
    }
}

// Colleague interface
interface Aircraft {
    void sendMessage(String message);
    void receiveMessage(String message);
    String getFlightNumber();
}

// Concrete colleague class
class Flight implements Aircraft {
    private AirTrafficControl atc;
    private String flightNumber;

    public Flight(AirTrafficControl atc, String flightNumber) {
        this.atc = atc;
        this.flightNumber = flightNumber;
    }

    public void sendMessage(String message) {
        atc.sendWarning(this, message);
    }

    public void receiveMessage(String message) {
        System.out.println("[Flight " + flightNumber + "] Message received: " + message);
    }

    public String getFlightNumber() {
        return flightNumber;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        AirTrafficControl atc = new AirTrafficControlImpl();

        Aircraft aircraft1 = new Flight(atc, "ABC123");
        Aircraft aircraft2 = new Flight(atc, "DEF456");
        Aircraft aircraft3 = new Flight(atc, "GHI789");

        atc.registerAircraft(aircraft1);
        atc.registerAircraft(aircraft2);
        atc.registerAircraft(aircraft3);

        aircraft1.sendMessage("Weather conditions deteriorating. Proceed with caution.");
        aircraft2.sendMessage("You are cleared for takeoff. Maintain heading 270.");

        aircraft3.receiveMessage("ATC advises all aircraft to land immediately due to emergency.");

        aircraft2.receiveMessage("Acknowledged. Heading 270 and cleared for takeoff.");
    }
}
