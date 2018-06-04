package com.example.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.entity.Vehicle;
import com.example.rest.repository.VehicleRepo;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepo vehicleRepo;
	
	@Transactional
	public void addVehicle(List<Vehicle> vehicle) {
		try {
			vehicle.forEach(veh -> vehicleRepo.save(veh));
		}
		catch(Exception e) {
			
		}
	}
	
	public List<Vehicle> getVehicle() {
		List<Vehicle> vehicle = new ArrayList<Vehicle>();
		try {
			vehicle = (List<Vehicle>) vehicleRepo.findAll();
		}
		catch(Exception e) {
			
		}
		return vehicle;
	}
}
