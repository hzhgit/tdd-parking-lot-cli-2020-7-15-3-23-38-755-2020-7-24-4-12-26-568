package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void should_return_not_enough_position_when_parking_boy_parking_given_parking_lot_no_postion(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for (int i = 0; i < 10; i++) {
            parkingLot.park(new Car());
        }
        Car car11 = new Car();

        //when
        String message = "";
        if(parkingLot.park(car11) == null){
            message = "Not enough position";
        }

        //then
        assertEquals("Not enough position",message);
    }

    @Test
    void should_return_parking_lot2_when_parking_lot1_is_full_given_11th_car(){
        //given
        ArrayList<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);

        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car());
        }

        //when
        Car car11 = new Car();
        parkingBoy.park(car11);
        List<ParkingLot> actual = parkingBoy.getParkingLots();

        //then
        assertEquals(0,actual.get(0).getEmptyPostion());
    }
}
