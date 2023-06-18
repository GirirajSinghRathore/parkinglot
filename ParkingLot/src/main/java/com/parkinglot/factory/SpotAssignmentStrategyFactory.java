package com.parkinglot.factory;

import com.parkinglot.model.SpotAssignmentStrategyType;
import com.parkinglot.repository.ParkingLotRepository;
import com.parkinglot.strategies.spotassignmentstrategy.NearestSpotAssignmentStrategy;
import com.parkinglot.strategies.spotassignmentstrategy.SpotAsignmentStrategy;

public class SpotAssignmentStrategyFactory {
	public SpotAsignmentStrategy getStrategy(SpotAssignmentStrategyType spotAssignmentStrategyType,ParkingLotRepository parkingLotRepository) {
		return new NearestSpotAssignmentStrategy(parkingLotRepository);
	}
}
