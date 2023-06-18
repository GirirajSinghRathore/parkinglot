package com.parkinglot.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import com.parkinglot.model.Gate;

public class GateRepository {
	private Map<Long,Gate> gates = new TreeMap<Long, Gate>();
	public Optional<Gate> findGatebyId(Long id){
		if(gates.get(id)!=null) {
			return Optional.of(gates.get(id));
		}
		return Optional.empty();
	}
}
