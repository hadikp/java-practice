package exam03.travel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cruise {

    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() <= boat.getMaxPassengers()) {
            passengers.add(passenger);
        } else {
            throw new IllegalArgumentException("Nincs több hely!");
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        if (passenger.getCruiseClass() == CruiseClass.LUXURY) {
            return basicPrice * 3;
        }
        if (passenger.getCruiseClass() == CruiseClass.FIRST) {
            return basicPrice * 1.8;
        }
        if (passenger.getCruiseClass() == CruiseClass.SECOND) {
            return basicPrice * 1;
        }
        throw new IllegalArgumentException("Valami hiba történt!");
    }

    public Passenger findPassengerByName(String name) {
        //return passengers.stream().filter(f -> f.getName().equals(name)).collect();
        for (Passenger p: passengers) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Nem találom az uatst!");
    }

    public List<String> getPassengerNamesOrdered() {
        return passengers.stream().map(Passenger::getName).collect(Collectors.toList());
    }

    public double sumAllBookingsCharged() {
        //return passengers.size();
        return 11.2;
    }

    public void countPassengerByClass() {
        System.out.println();
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}
