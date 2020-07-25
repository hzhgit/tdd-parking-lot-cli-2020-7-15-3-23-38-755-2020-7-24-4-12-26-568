package com.oocl.cultivation;

import sun.security.krb5.internal.Ticket;

import java.util.ArrayList;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket park() {
        return null;
    }
}
