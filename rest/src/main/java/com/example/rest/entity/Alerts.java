package com.example.rest.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Alerts.getHighAlerts", query = "SELECT a FROM Alerts a WHERE a.priority = 'HIGH' AND a.timestamp > :input"),
	@NamedQuery(name = "Alerts.getAlertsByVehicle", query = "SELECT a FROM Alerts a WHERE a.vin = :input")
})
public class Alerts {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String vin;
	private String priority;
	private Date timestamp;
	
	public Alerts() {
		
	}

	public Alerts(int id, String vin, String priority, Date timestamp) {
		super();
		this.id = id;
		this.vin = vin;
		this.priority = priority;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public String getVin() {
		return vin;
	}

	public String getPriority() {
		return priority;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
