package com.routemasterapi.api.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.routemasterapi.api.entity.RouterEntity;

@Repository
public interface RouterRepository extends CrudRepository<RouterEntity, Integer> {

  
    @Query(value = "select * from kishore_routes", nativeQuery = true) 
    Page<RouterEntity> findAll(Pageable pageable);

}
