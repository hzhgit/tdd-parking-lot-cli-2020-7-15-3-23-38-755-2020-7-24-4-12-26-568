package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyTest {
    @Test
    void should_return_unrecognized_parking_ticket_when_customer_fetch_car_given_wrong_ticket() {
        //given
        CarTicket ticket = new CarTicket();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        String message = parkingBoy.say(ticket);
        //then
        assertEquals("Unrecognized parking ticket.", message);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_customer_fetch_car_given_ticket_used() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        CarTicket ticket = parkingLot.park(car);
        Car fetchCar = parkingLot.fetch(ticket);

        //when
        String message = "";
        Car fetchAgainCar = parkingLot.fetch(ticket);
        if(fetchAgainCar == null)
            message = parkingBoy.say(ticket);
        //then
        assertEquals("Unrecognized parking ticket.", message);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_customer_fetch_car_given_none() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        String message = parkingBoy.say((CarTicket) (null));

        //then
        assertEquals("Please provide your parking ticket.", message);
    }
}
