package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public ParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public String say(CarTicket wrongTicket) {
        if (wrongTicket == null)
            return "Please provide your parking ticket.";
        return "Unrecognized parking ticket.";
    }

    public CarTicket park(Car car) {
        return null;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
