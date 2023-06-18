package com.parkinglot.repository;

import java.util.Map;
import java.util.TreeMap;

import com.parkinglot.model.Gate;
import com.parkinglot.model.ParkingLot;

public class ParkingLotRepository {
	Map<Long,ParkingLot> parkingLots = new TreeMap<Long, ParkingLot>();
	public ParkingLot getParkingLotfromGate(Gate gate) {
		for(Map.Entry<Long, ParkingLot> e:parkingLots.entrySet()) {
			if(e.getValue().getGates().contains(gate)) {
				return e.getValue();
			}
		}
		return null;
	}
}
