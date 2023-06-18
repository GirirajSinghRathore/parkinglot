package com.parkinglot.model.service.strategies.spotassignmentstrategy;

import java.util.Iterator;

import com.parkinglot.model.Gate;
import com.parkinglot.model.ParkingFloor;
import com.parkinglot.model.ParkingLot;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.ParkingSpotStatus;
import com.parkinglot.model.SpotAssignmentStrategyType;
import com.parkinglot.model.VehicleType;
import com.parkinglot.model.service.repository.ParkingLotRepository;

public class NearestSpotAssignmentStrategy implements SpotAsignmentStrategy{
	ParkingLotRepository parkingLotRepository;
	public NearestSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository) {
		this.parkingLotRepository=parkingLotRepository;
	}
	public ParkingSpot getSpot(Gate gate, VehicleType vehicleType) {
		ParkingLot parkingLot = parkingLotRepository.getParkingLotfromGate(gate);
		for (ParkingFloor floor : parkingLot.getParkingFloors()) {
			for(ParkingSpot parkingSpot:floor.getParkingSpots()) {
				if(parkingSpot.getSupporteVehicleType().equals(vehicleType)&&parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)) {
					parkingSpot.setParkingSpotStatus(ParkingSpotStatus.FILLED);
					return parkingSpot;
				}
			}
		}
		return null;
	}

}
