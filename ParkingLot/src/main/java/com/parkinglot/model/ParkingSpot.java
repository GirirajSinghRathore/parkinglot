package com.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpot extends ParkingFloor {
	private VehicleType supporteVehicleType;
	private ParkingSpotStatus parkingSpotStatus;
	private int spotNumber;
	private ParkingFloor parkingFloor;
}
