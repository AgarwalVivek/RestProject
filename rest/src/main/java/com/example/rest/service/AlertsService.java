package com.example.rest.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.entity.Alerts;
import com.example.rest.entity.Readings;
import com.example.rest.entity.Vehicle;
import com.example.rest.repository.AlertsRepo;
import com.example.rest.repository.VehicleRepo;

@Service
public class AlertsService {

	@Autowired
	private AlertsRepo alertsRepo;
	
	@Autowired
	private VehicleRepo vehicleRepo;
	
	@Transactional
	public void addAlerts(Readings readings) {
		try {
			Alerts alerts = new Alerts();
			String vin = readings.getVin();
			Optional<Vehicle> vehicle = vehicleRepo.findById(vin);
			if(vehicle.isPresent()) {
				if(readings.getEngineRpm() > vehicle.get().getRedlineRpm()) {
					alerts.setPriority("HIGH");
					alerts.setTimestamp(readings.getTimestamp());
					alerts.setVin(vin);
					alertsRepo.save(alerts);
				}
				if(readings.getFuelVolume() < (vehicle.get().getMaxFuelVolume() * 10/100)) {
					alerts.setPriority("MEDIUM");
					alerts.setTimestamp(readings.getTimestamp());
					alerts.setVin(vin);
					alertsRepo.save(alerts);
				}
				if(readings.getTires().getFrontLeft() < 32 || readings.getTires().getFrontLeft() > 36) {
					alerts.setPriority("LOW");
					alerts.setTimestamp(readings.getTimestamp());
					alerts.setVin(vin);
					alertsRepo.save(alerts);
				}
				if(readings.getTires().getFrontRight() < 32 || readings.getTires().getFrontRight() > 36) {
					alerts.setPriority("LOW");
					alerts.setTimestamp(readings.getTimestamp());
					alerts.setVin(vin);
					alertsRepo.save(alerts);
				}
				if(readings.getTires().getRearLeft() < 32 || readings.getTires().getRearLeft() > 36) {
					alerts.setPriority("LOW");
					alerts.setTimestamp(readings.getTimestamp());
					alerts.setVin(vin);
					alertsRepo.save(alerts);
				}
				if(readings.getTires().getRearRight() < 32 || readings.getTires().getRearRight() > 36) {
					alerts.setPriority("LOW");
					alerts.setTimestamp(readings.getTimestamp());
					alerts.setVin(vin);
					alertsRepo.save(alerts);
				}
			}
		}
		catch(Exception e) {
			
		}
	}
	
	@Transactional
	public List<Alerts> getHighAlerts(){
		List<Alerts> alertsList = new ArrayList<Alerts>();
		try {
			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			calendar.setTime(new Date());
			calendar.add(Calendar.MINUTE, -30);
			Date dateAfter = calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(dateAfter);
			Date finalDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
			alertsList = alertsRepo.getHighAlerts(finalDate);
		}
		catch(Exception e) {
			
		}
		return alertsList;
	}
	
	public List<Alerts> getAlertsByVehicle(String vin){
		List<Alerts> alertsList = new ArrayList<Alerts>();
		try {
			alertsList = alertsRepo.getAlertsByVehicle(vin);
		}
		catch(Exception e) {
			
		}
		return alertsList;
	}
}
