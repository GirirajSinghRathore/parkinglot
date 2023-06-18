package com.parkinglot.model.service.strategies.spotassignmentstrategy.factory;

import com.parkinglot.model.SpotAssignmentStrategyType;
import com.parkinglot.model.service.repository.ParkingLotRepository;
import com.parkinglot.model.service.strategies.spotassignmentstrategy.NearestSpotAssignmentStrategy;
import com.parkinglot.model.service.strategies.spotassignmentstrategy.SpotAsignmentStrategy;

public class SpotAssignmentStrategyFactory {
	public SpotAsignmentStrategy getStrategy(SpotAssignmentStrategyType spotAssignmentStrategyType,ParkingLotRepository parkingLotRepository) {
		return new NearestSpotAssignmentStrategy(parkingLotRepository);
	}
}
