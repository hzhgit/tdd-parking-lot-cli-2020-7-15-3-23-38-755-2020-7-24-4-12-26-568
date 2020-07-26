package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {
    @Test
    void should_parking_car_at_pot2_when_super_smart_parking_boy_park_given_pot2_utilization_is_the_smallest() {
        //given
        List<ParkingLot> parkingLots = new ArrayList<>();
        ParkingLot pot1 = new ParkingLot(5);
        ParkingLot pot2 = new ParkingLot(10);
        ParkingLot pot3 = new ParkingLot(20);
        parkingLots.add(pot1);
        parkingLots.add(pot2);
        parkingLots.add(pot3);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy((ArrayList<ParkingLot>) parkingLots);

        //pot1 has 1 car
        Car car = new Car();
        pot1.park(car);
        //pot2 has 4 car
        for (int i = 0; i < 4; i++) {
            pot2.park(new Car());
        }
        //pot3 has 10 car
        for (int i = 0; i < 10; i++) {
            pot3.park(new Car());
        }

        Car newCar = new Car();
        superSmartParkingBoy.park(car);

        //when
        int actual1 = pot1.getEmptyPostion();
        int actual2 = pot2.getEmptyPostion();
        int actual3 = pot3.getEmptyPostion();

        //then
        assertEquals(4,actual1);
        assertEquals(5,actual2);
        assertEquals(10,actual3);
    }
}
