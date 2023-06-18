package com.parkinglot;

import com.parkinglot.controller.TicketController;
import com.parkinglot.repository.GateRepository;
import com.parkinglot.repository.ParkingLotRepository;
import com.parkinglot.repository.TicketRepository;
import com.parkinglot.repository.VehicleRepository;
import com.parkinglot.service.TicketService;
import com.parkinglot.strategies.spotassignmentstrategy.factory.SpotAssignmentStrategyFactory;

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
