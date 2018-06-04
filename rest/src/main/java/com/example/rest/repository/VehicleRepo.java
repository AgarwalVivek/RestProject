package com.example.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.entity.Vehicle;

@Repository
public interface VehicleRepo extends CrudRepository<Vehicle, String> {

}
