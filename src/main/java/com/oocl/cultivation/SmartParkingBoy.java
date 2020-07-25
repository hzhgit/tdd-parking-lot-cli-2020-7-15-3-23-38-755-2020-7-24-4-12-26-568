package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {
        List<ParkingLot> parkingLots= super.getParkingLots();
        int parkingLotNumber = parkingLots.size();
        int maxNumber = 0;
        int selectPotIndex = 0;
        for (int i = 0; i < parkingLotNumber; i++) {
            if(parkingLots.get(i).getEmptyPostion() > maxNumber){
                maxNumber = parkingLots.get(i).getEmptyPostion();
                selectPotIndex = i;
            }
        }

        return parkingLots.get(selectPotIndex).park(car);
    }
}
