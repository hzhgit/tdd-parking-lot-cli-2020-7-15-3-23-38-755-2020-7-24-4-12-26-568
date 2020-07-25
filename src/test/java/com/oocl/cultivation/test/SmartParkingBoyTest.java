package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    void should_parking_car_at_pot1_when_parking_a_car_given_pot1_has_10_empty_postion_and_pot2_has_10_postion() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot pot1 = new ParkingLot();
        ParkingLot pot2 = new ParkingLot();
        parkingLots.add(pot1);
        parkingLots.add(pot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy((ArrayList<ParkingLot>) parkingLots);
        Car car = new Car();
        smartParkingBoy.park(car);

        //when
        int actual = pot1.getEmptyPostion();
        int actua2 = pot2.getEmptyPostion();

        //then
        assertEquals(9,actual);
        assertEquals(10,actua2);
    }
}
