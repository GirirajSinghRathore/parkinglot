package com.parkinglot.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ParkingFloor extends BaseModel {
	private List<ParkingSpot> parkingSpots;
	private Long floorNumber;
}
