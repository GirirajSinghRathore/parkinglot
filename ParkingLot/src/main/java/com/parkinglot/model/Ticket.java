package com.parkinglot.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Ticket extends BaseModel{
	private int ticketId;
	private Date entryTime;
	private Vehicle vehicle;
	private ParkingSpot parkingSpot;
	private Gate generteAt;
	private Operator generatedBy;
	
}
