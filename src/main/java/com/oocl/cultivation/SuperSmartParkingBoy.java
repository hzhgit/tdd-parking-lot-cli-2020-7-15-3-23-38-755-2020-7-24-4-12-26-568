package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy extends SmartParkingBoy implements Parkable{

    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SuperSmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {
        List<ParkingLot> parkingLots = super.getParkingLots();

        parkingLots = this.getParkingLots().stream()
                .filter(lot -> !lot.isParkingLotFull())
                .sorted(Comparator.comparing(ParkingLot::getUtilization))
                .collect(Collectors.toList());

        return parkingLots.get(0).park(car);
    }
}
