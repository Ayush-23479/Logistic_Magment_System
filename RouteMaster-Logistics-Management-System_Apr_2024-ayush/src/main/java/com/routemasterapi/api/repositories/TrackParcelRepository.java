package com.routemasterapi.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.routemasterapi.api.entity.TrackParcelEntity;
import com.routemasterapi.api.entity.customerentity;

public interface TrackParcelRepository extends CrudRepository<TrackParcelEntity, Integer>{
	@Query(value = "select * from  kishore_TrackParcel2 ", nativeQuery = true)
    Page<TrackParcelEntity> listalltrackparcelsfromdb(Pageable pageable);
}
