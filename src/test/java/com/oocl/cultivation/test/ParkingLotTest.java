package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    void shold_return_mutiple_tickets_when_park_car_in_parking_lot_given_mutiple_cars() {
        // given
        List<Car> cars = new ArrayList<Car>();
        ParkingLot parkingLot = new ParkingLot();

        //when
        List<CarTicket> tickets = parkingLot.parkMutipleCar(cars);

        //then
        assertEquals(cars.size(), tickets.size());
    }

    @Test
    void should_return_right_car_when_fetch_car_given_ticket() {
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
        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
        assertNotEquals(car1, car2);
    }

    @Test
    void should_return_null_when_customer_given_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        CarTicket ticket = new CarTicket();

        //when
        Car car = parkingLot.fetch(ticket);

        //then
        assertNull(car);
    }

    @Test
    void should_return_null_when_customer_given_null_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();

        //when
        Car car = parkingLot.fetch(null);

        //then
        assertNull(car);
    }

    @Test
    void should_return_null_when_customer_given_ticket_has_used(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        CarTicket ticket = parkingLot.park(car);
        Car fetchcar = parkingLot.fetch(ticket);

        //when
        Car fetchcarAgain = parkingLot.fetch(ticket);

        //then
        assertNull(fetchcarAgain);
    }

    @Test
    void should_return_null_when_parking_lot_10_postion_all_were_used_given_11th_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        for (int i = 0; i < 10; i++) {
            parkingLot.park(new Car());
        }
        Car car11 = new Car();

        //when
        CarTicket ticket = parkingLot.park(car11);

        //then
        assertNull(ticket);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_customer_fetch_car_given_wrong_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        CarTicket wrongTicket = new CarTicket();
        CarTicket rightTicket = parkingLot.park(car);

        //when
        String wrongMesasage = parkingLot.say(wrongTicket);

        //then
        assertEquals("Unrecognized parking ticket",wrongMesasage);
    }

    @Test
    void should_return_please_provide_your_parking_ticket_when_customer_fetch_car_given_none() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        String wrongMesasage = parkingLot.say(null);

        //then
        assertEquals("Please provide your parking ticket",wrongMesasage);
    }


}
