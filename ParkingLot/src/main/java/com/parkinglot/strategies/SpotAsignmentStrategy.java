package com.parkinglot.strategies;

import com.parkinglot.model.Gate;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.VehicleType;

public interface SpotAsignmentStrategy {
	ParkingSpot getSpot(Gate gate,VehicleType vehicleType);
}
