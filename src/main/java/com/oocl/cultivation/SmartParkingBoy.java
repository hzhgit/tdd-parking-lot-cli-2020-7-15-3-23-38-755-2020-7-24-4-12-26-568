package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy implements Parkable{

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    @Override
    public CarTicket park(Car car) {
        List<ParkingLot> parkingLots = super.getParkingLots();

        parkingLots = this.getParkingLots().stream().filter(lot -> !lot.isParkingLotFull()).sorted((firstLot, secendLot) -> {
            return secendLot.getEmptyPostion() - firstLot.getEmptyPostion();
        }).collect(Collectors.toList());

        return parkingLots.get(0).park(car);
    }
}
