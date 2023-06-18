package com.parkinglot.model.service;

import java.sql.Date;
import java.util.Optional;

import com.parkinglot.model.Gate;
import com.parkinglot.model.SpotAssignmentStrategyType;
import com.parkinglot.model.Ticket;
import com.parkinglot.model.Vehicle;
import com.parkinglot.model.VehicleType;
import com.parkinglot.model.service.repository.GateRepository;
import com.parkinglot.model.service.repository.ParkingLotRepository;
import com.parkinglot.model.service.repository.TicketRepository;
import com.parkinglot.model.service.repository.VehicleRepository;
import com.parkinglot.model.service.strategies.spotassignmentstrategy.SpotAsignmentStrategy;
import com.parkinglot.model.service.strategies.spotassignmentstrategy.factory.SpotAssignmentStrategyFactory;

public class TicketService {
	GateRepository gateRepository;
	VehicleRepository vehicleRepository;
	ParkingLotRepository parkingLotRepository;
	SpotAssignmentStrategyFactory spotAssignmentStrategyFactory;
	TicketRepository ticketRepository;

	public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository,
			ParkingLotRepository parkingLotRepository, SpotAssignmentStrategyFactory spotAssignmentStrategyFactory,
			TicketRepository ticketRepository) {
		this.gateRepository = gateRepository;
		this.vehicleRepository = vehicleRepository;
		this.parkingLotRepository = parkingLotRepository;
		this.spotAssignmentStrategyFactory = spotAssignmentStrategyFactory;
		this.ticketRepository = ticketRepository;
	}

	public Ticket issueTicket(VehicleType type, String vehicleNumber, String vehicleOwnerName, Long gateId)
			throws Exception {
		Ticket ticket = new Ticket();
		ticket.setCreateAt(new  Date(0));
		Optional<Gate> gate = gateRepository.findGatebyId(gateId);
		if (gate.isEmpty()) {
			throw new Exception();
		}
		ticket.setGenerteAt(gate.get());
		ticket.setGeneratedBy(gate.get().getGateOperator());
		Optional<Vehicle> vehicle = vehicleRepository.findVehicleById(vehicleNumber);
		if (vehicle.isEmpty()) {
			Vehicle vehicle2 = new Vehicle();
			vehicle2.setNumber(vehicleNumber);
			vehicle2.setOwnerName(vehicleOwnerName);
			vehicle2.setType(type);
			ticket.setVehicle(vehicleRepository.saveVehicle(vehicle2));
		} else {
			ticket.setVehicle(vehicle.get());
		}
		SpotAssignmentStrategyType spotAssignmentStrategyType = parkingLotRepository.getParkingLotfromGate(gate.get())
				.getSpotAssignmentStrategyType();
		SpotAsignmentStrategy asignmentStrategy = spotAssignmentStrategyFactory.getStrategy(spotAssignmentStrategyType,parkingLotRepository);
		ticket.setParkingSpot(asignmentStrategy.getSpot(gate.get(), type));
		ticketRepository.saveTicket(ticket);
		return ticket;
	}
}
