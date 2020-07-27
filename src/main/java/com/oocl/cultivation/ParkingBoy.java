package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy implements Parkable{
    private List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots = new ArrayList<>();
        this.parkingLots.add(parkingLot);
    }

    public ParkingBoy(ArrayList<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public String getErrorMessage(CarTicket wrongTicket) {
        if (wrongTicket == null)
            return "Please provide your parking ticket.";
        return "Unrecognized parking ticket.";
    }

    public String getErrorMessage(Car car) {
        return "Not enough position";
    }

    public CarTicket park(Car car) {
        for (ParkingLot parkingLot : this.parkingLots) {
            if (parkingLot.getEmptyPostion() > 0) {
                return parkingLot.park(car);
            }
        }
        return null;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
