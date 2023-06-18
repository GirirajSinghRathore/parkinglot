package com.parkinglot.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BaseModel {
	private Long id;
	private Date createAt;
	private Date lastModifiedAt;
}
