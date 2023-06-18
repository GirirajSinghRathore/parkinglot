package com.parkinglot.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Payment {
	private PaymentMode paymentMode;
	private int amount;
	private Date time;
	private PaymentStatus paymentStatus;
	private String referenceNumber;
	
}
