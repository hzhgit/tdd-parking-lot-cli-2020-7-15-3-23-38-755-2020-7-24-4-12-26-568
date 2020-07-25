package com.oocl.cultivation;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public String say(CarTicket wrongTicket) {
        if (wrongTicket == null)
            return "Please provide your parking ticket.";
        return "Unrecognized parking ticket.";
    }
}
