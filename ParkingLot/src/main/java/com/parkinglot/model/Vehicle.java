package com.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle extends BaseModel {
	private String number;
	private VehicleType type;
	private String ownerName;
}
