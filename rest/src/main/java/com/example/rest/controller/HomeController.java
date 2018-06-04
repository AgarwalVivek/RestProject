package com.example.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entity.Alerts;
import com.example.rest.entity.Readings;
import com.example.rest.entity.Vehicle;
import com.example.rest.service.AlertsService;
import com.example.rest.service.ReadingsService;
import com.example.rest.service.VehicleService;

@CrossOrigin("*")
@RestController
public class HomeController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private ReadingsService readingsService;
	
	@Autowired
	private AlertsService alertsService;
	
	@PutMapping("/vehicles")
	public void addVehicle(@RequestBody List<Vehicle> vehicle) {
		try {
			vehicleService.addVehicle(vehicle);
		}
		catch(Exception e) {
			
		}
	}
	
	@PostMapping("/readings")
	public void addReadings(@RequestBody Readings readings) {
		try {
			readingsService.addReadings(readings);
			alertsService.addAlerts(readings);
		}
		catch(Exception e) {
			
		}
	}
	
	@GetMapping("/getVehicle")
	public List<Vehicle> getVehicle(){
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		try {
			vehicleList = vehicleService.getVehicle();
		}
		catch(Exception e) {
			
		}
		return vehicleList;
	}
	
	@GetMapping("/getHighAlerts")
	public List<Alerts> getHighAlerts(){
		List<Alerts> alertsList = new ArrayList<Alerts>();
		try {
			alertsList = alertsService.getHighAlerts();
		}
		catch(Exception e) {
			
		}
		return alertsList;
	}
	
	@GetMapping("/getAlertsByVehicle/{vin}")
	public List<Alerts> getAlertsByVehicle(@PathVariable String vin) {
		List<Alerts> alertsList = new ArrayList<Alerts>();
		try {
			alertsList = alertsService.getAlertsByVehicle(vin);
		}
		catch(Exception e) {
			
		}
		return alertsList;
	}
	
	@GetMapping("/getGeolocation/{vin}")
	public List<Readings> getGeolocation(@PathVariable String vin) {
		List<Readings> readingsList = new ArrayList<Readings>();
		try {
			readingsList = readingsService.getGeolocation(vin);
		}
		catch(Exception e) {
			
		}
		return readingsList;
	}
	
	
}
