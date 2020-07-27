package com.oocl.cultivation;

import java.util.List;

public class Manager {
    private final List<Parkable> parkables;

    public Manager(List<Parkable> parkables) {
        this.parkables = parkables;
    }

    public CarTicket park(Parkable parkable,Car car) {
        return parkable.park(car);
    }
}
