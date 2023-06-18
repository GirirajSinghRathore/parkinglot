package com.parkinglot.model.service.repository;

import java.util.Map;
import java.util.TreeMap;

import com.parkinglot.model.ParkingLot;
import com.parkinglot.model.Ticket;

public class TicketRepository {
	Map<Long,Ticket> tickets = new TreeMap<Long, Ticket>();
	Long id=0L;
	public Ticket saveTicket(Ticket ticket) {
		id++;
		ticket.setId(id);
		tickets.put(id, ticket);
		return ticket;
	}
}
