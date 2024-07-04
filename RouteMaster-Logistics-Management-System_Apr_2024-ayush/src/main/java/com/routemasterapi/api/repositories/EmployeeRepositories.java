package com.routemasterapi.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.routemasterapi.api.entity.EmployeeEntity;

import com.routemasterapi.api.entity.customerentity;
@Repository
public interface EmployeeRepositories extends CrudRepository<EmployeeEntity, Integer>{
	  @Query(value = "SELECT * FROM kishore_employee", nativeQuery = true)
	  Page<EmployeeEntity> findAllEmployees(Pageable pageable);
}


