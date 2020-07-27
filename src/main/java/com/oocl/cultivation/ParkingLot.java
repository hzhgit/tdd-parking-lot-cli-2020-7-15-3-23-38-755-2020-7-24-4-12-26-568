package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private Map<CarTicket, Car> carRooms = new HashMap();
    private int postionNum;

    public ParkingLot() {
        this.postionNum = 10;
    }

    public ParkingLot(int postionNum) {
        this.postionNum = postionNum;
    }

    public CarTicket park(Car car) {
        if(carRooms.size() != this.postionNum){
            CarTicket carTicket = new CarTicket();
            carRooms.put(carTicket,car);
            return carTicket;
        }
        return null;
    }

    public Car fetch(CarTicket ticket) {
        Car fetchedCar = carRooms.get(ticket);
        carRooms.remove(ticket);
        return fetchedCar;
    }

    public List<CarTicket> parkMutipleCar(List<Car> cars) {
        List<CarTicket> tickets = new ArrayList<>();
        for (Car car : cars) {
            tickets.add(park(car));
        }
        return tickets;
    }

    public int getEmptyPostion() {
        return this.postionNum - this.carRooms.size();
    }

    public double getUtilization() {
        return (double)this.carRooms.size() / this.postionNum;
    }

    public boolean isParkingLotFull() {
        return this.carRooms.size() == this.postionNum;
    }
}
