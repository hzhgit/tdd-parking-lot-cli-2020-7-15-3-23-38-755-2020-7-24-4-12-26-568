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
        //when
        CarTicket ticket1 = manager.askParkingBoyToPark(parkables.get(0),new Car());
        CarTicket ticket2 = manager.askParkingBoyToPark(parkables.get(1),new Car());
        CarTicket ticket3 = manager.askParkingBoyToPark(parkables.get(2),new Car());
        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotNull(ticket3);
    }
}
