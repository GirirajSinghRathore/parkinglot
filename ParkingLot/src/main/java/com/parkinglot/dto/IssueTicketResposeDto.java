package com.parkinglot.dto;

import com.parkinglot.model.Ticket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter 
@Setter
@AllArgsConstructor
public class IssueTicketResposeDto {
private Ticket ticket;
private ResponseStatus responseStatus;

}
