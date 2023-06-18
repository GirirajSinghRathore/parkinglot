package com.parkinglot.controller;

import com.parkinglot.dto.IssueTicketRequestDto;
import com.parkinglot.dto.IssueTicketResposeDto;
import com.parkinglot.dto.ResponseStatus;
import com.parkinglot.model.Ticket;
import com.parkinglot.service.TicketService;

public class TicketController {
	private TicketService ticketService;
	public TicketController(TicketService ticketService) {
		this.ticketService=ticketService;
	}
	public IssueTicketResposeDto issueTicket(IssueTicketRequestDto dto) {
		try {
			Ticket ticket = ticketService.issueTicket(dto.getType(), dto.getVehicleNumber(), dto.getOwnerName(), dto.getGateId());
			return new IssueTicketResposeDto(ticket, ResponseStatus.SUCCESS);
		} catch (Exception e) {
			return new IssueTicketResposeDto(null, ResponseStatus.FALIURE);
		}
		
	}
}
