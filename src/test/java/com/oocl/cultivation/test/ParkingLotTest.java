package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticker_when_par_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        CarTicket carTicket = parkingLot.park(car);

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_car_when_fetch_car_given_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket = parkingLot.park(new Car());

        //when
        Car car = parkingLot.fetch(carTicket);

        //then
        assertNotNull(car);
    }

    @Test
    void should_return_right_car_when_fetch_car_given_ticket(){
        //given
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket carTicket1 = parkingLot.park(car1);
        CarTicket carTicket2 = parkingLot.park(car2);

        //when
        Car fetchedCar1 = parkingLot.fetch(carTicket1);
        Car fetchedCar2 = parkingLot.fetch(carTicket2);

        //then
        assertEquals(car1,fetchedCar1);
        assertEquals(car2,fetchedCar2);
        assertNotEquals(car1,car2);
    }
}
