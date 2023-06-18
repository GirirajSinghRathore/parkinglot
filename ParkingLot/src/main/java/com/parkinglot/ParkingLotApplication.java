package com.parkinglot;

import com.parkinglot.model.controller.TicketController;
import com.parkinglot.model.service.TicketService;
import com.parkinglot.model.service.repository.GateRepository;
import com.parkinglot.model.service.repository.ParkingLotRepository;
import com.parkinglot.model.service.repository.TicketRepository;
import com.parkinglot.model.service.repository.VehicleRepository;
import com.parkinglot.model.service.strategies.spotassignmentstrategy.factory.SpotAssignmentStrategyFactory;

public class ParkingLotApplication {
	public static void main(String[] args) {
		GateRepository gateRepository=  new GateRepository();
		ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
		TicketRepository ticketRepository = new TicketRepository();
		SpotAssignmentStrategyFactory spotAssignmentStrategyFactory = new SpotAssignmentStrategyFactory();
		VehicleRepository vehicleRepository = new VehicleRepository();
		TicketService ticketService = new TicketService(gateRepository, vehicleRepository, parkingLotRepository, spotAssignmentStrategyFactory, ticketRepository);
		TicketController ticketController = new TicketController(ticketService);
		ticketController.issueTicket(null);
	}
}
