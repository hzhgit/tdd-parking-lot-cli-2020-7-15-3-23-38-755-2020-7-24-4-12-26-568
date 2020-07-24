package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        CarTicket carTicket = new CarTicket();
        ParkingLot parkingLot = new ParkingLot();

        //when
        Car car = parkingLot.fetch(carTicket);

        //then
        assertNotNull(car);
    }

    @Test
    void shold_return_mutiple_tickets_when_park_car_in_parking_lot_given_mutiple_cars() {
        // given
        List<Car> cars = new ArrayList<Car>();
        ParkingLot parkingLot = new ParkingLot();

        //when
        List<CarTicket> tickets = parkingLot.parkMutipleCar(cars);

        //then
        assertEquals(cars.size(),tickets.size());
    }

    @Test
    void should_return_right_car_when_fetch_car_given_ticket(){
        //given
        Car car = new Car();
        CarTicket ticket = new CarTicket();
        ParkingLot parkingLot = new ParkingLot();

        //when

        Car rightCar = parkingLot.fetch(ticket);

        //then
        assertEquals(car,rightCar);
    }
}
