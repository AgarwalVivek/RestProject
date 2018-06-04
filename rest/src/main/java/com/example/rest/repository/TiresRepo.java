package com.example.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.entity.Tires;

@Repository
public interface TiresRepo extends CrudRepository<Tires, String> {

}
