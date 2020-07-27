package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ManagerTest {
    @Test
    void should_return_ticket_when_park_given_car() {
        //given
        List<Parkable> parkables = new ArrayList<>();
        parkables.add((Parkable) new ParkingBoy(new ParkingLot()));
        parkables.add((Parkable) new SmartParkingBoy(new ParkingLot()));
        parkables.add((Parkable) new SuperSmartParkingBoy(new ParkingLot()));

        Manager manager = new Manager(parkables);
        Car car = new Car();
        //when
        CarTicket ticket = manager.park(car);
        //then
        assertNotNull(ticket);
    }
}
