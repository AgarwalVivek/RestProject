package com.example.rest.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.entity.Readings;
import com.example.rest.repository.ReadingsRepo;
import com.example.rest.repository.TiresRepo;

@Service
public class ReadingsService {
	
	@Autowired
	private ReadingsRepo readingsRepo;
	
	@Autowired
	private TiresRepo tiresRepo;
	
	public void addReadings(Readings readings) {
		try {
			tiresRepo.save(readings.getTires());
			readingsRepo.save(readings);
		}
		catch(Exception e) {
			
		}
	}
	
	public List<Readings> getGeolocation(String vin){
		List<Readings> readingsList = new ArrayList<Readings>();
		try {
			Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			calendar.setTime(new Date());
			calendar.add(Calendar.MINUTE, -30);
			Date dateAfter = calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = sdf.format(dateAfter);
			Date finalDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
			readingsList = readingsRepo.getGeolocation(vin, finalDate);
		}
		catch(Exception e) {
			
		}
		return readingsList;
	}
}
