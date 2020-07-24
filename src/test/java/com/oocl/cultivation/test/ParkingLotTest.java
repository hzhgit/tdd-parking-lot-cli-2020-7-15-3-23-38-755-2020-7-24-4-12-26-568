package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_ticker_when_par_given_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        CarTicket carTicket = parkingLot.park();

        //then
        assertNotNull(carTicket);
    }

    @Test
    void should_return_car_when_fetch_car_given_ticket() {
        //given
        CarTicket carTicket = new CarTicket();
        ParkingLot parkingLot = new ParkingLot();

        //when
        Car car = parkingLot.fetch();

        //then
        assertNotNull(car);
    }
}
