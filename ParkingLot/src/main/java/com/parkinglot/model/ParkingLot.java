package com.parkinglot.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ParkingLot extends BaseModel {
	private List<ParkingFloor> parkingFloors;
	private List<Gate> gates;
	private List<VehicleType> vehicleTypes;
	private ParkingLotStatus parkingLotStatus;
	private SpotAssignmentStrategyType spotAssignmentStrategyType;
	private FeeCalculatorStrategyType feeCalculatorStrategyType;
}
