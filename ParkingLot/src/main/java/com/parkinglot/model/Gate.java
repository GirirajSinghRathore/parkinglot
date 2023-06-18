package com.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate extends BaseModel {
	private int gateNumber;
	private GateType gateType;
	private Operator gateOperator;
	private GateStatus gateStatus;
}
