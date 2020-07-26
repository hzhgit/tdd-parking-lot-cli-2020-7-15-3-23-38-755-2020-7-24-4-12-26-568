package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class SuperSmartParkingBoy extends SmartParkingBoy{

    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car){
        List<ParkingLot> parkingLots = super.getParkingLots();
        int selectPotIndex = 0;
        double minUtilization = 1;
        for (int i = 0; i < parkingLots.size(); i++) {
            if(parkingLots.get(i).getUtilization() < minUtilization){
                minUtilization = parkingLots.get(i).getUtilization();
                selectPotIndex = i;
            }
        }
        return parkingLots.get(selectPotIndex).park(car);
    }
}
