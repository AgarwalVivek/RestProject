package com.example.rest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rest.entity.Alerts;

@Repository
public interface AlertsRepo extends CrudRepository<Alerts, String> {
	public List<Alerts> getHighAlerts(@Param("input") Date input);
	public List<Alerts> getAlertsByVehicle(@Param("input") String input);
}
