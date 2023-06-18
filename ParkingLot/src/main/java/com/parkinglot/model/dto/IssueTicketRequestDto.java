package com.parkinglot.model.dto;

import com.parkinglot.model.VehicleType;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class IssueTicketRequestDto {
	private VehicleType type;
	private String vehicleNumber;
	private String ownerName;
	private Long gateId;
	
}
