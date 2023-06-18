package com.parkinglot.model.controller;

import com.parkinglot.model.Ticket;
import com.parkinglot.model.dto.IssueTicketRequestDto;
import com.parkinglot.model.dto.IssueTicketResposeDto;
import com.parkinglot.model.dto.ResponseStatus;
import com.parkinglot.model.service.TicketService;

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
