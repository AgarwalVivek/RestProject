package com.example.rest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.rest.entity.Readings;

@Repository
public interface ReadingsRepo extends CrudRepository<Readings, String> {
	public List<Readings> getGeolocation(@Param("input1") String input1, @Param("input2") Date input2);
}
