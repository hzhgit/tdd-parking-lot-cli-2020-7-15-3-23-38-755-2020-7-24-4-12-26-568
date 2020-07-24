package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket, Car> carRooms = new HashMap();

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        carRooms.put(carTicket,car);
        return carTicket;
    }

    public Car fetch(CarTicket ticket) {
        return carRooms.get(ticket);
    }

    public List<CarTicket> parkMutipleCar(List<Car> cars) {
        List<CarTicket> tickets = new ArrayList<>();
        for (Car car : cars) {
            tickets.add(park(car));
        }
        return tickets;
    }
}
