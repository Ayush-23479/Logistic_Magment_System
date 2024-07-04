package com.routemasterapi.api.repositories;
import java.time.LocalDate;
import java.util.List;

 import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.routemasterapi.api.entity.ParcelEntity;
//import com.routemasterapi.api.model.ParcelRequestBody;
 
@Repository
public interface  ParcelRepository extends CrudRepository<ParcelEntity,Integer> {

	@Query(value = "select * from  ayush_parcel ", nativeQuery = true)
	Page<ParcelEntity> listallparcelsfromdb(Pageable pageable);

	@Query(value = "SELECT * FROM ayush_parcel WHERE CustomerID = :customerId", nativeQuery = true)
	Page<ParcelEntity> listcustomerparcelstatusfromdb(@Param("customerId") int customerId, Pageable pageable);

	@Query(value = "SELECT * FROM ayush_parcel WHERE createdDate >= :oneMonthAgo ", nativeQuery = true)
	Page<ParcelEntity> listonemonthparcelsfromdb(@Param("oneMonthAgo") LocalDate oneMonthAgo, Pageable pageable);
	
	@Query(value = "SELECT * FROM ayush_parcel WHERE createdDate >= :oneMonthAgo AND parcelStatus = 'Delayed' ", nativeQuery = true)
	Page<ParcelEntity> listonemonthdelayedparcelsfromdb(@Param("oneMonthAgo") LocalDate oneMonthAgo, Pageable pageable);

	 @Query("SELECT SUM(p.totalPayment) FROM ParcelEntity p")
	    double sumTotalPayment();
	 @Query("SELECT p.route.name, COUNT(p) FROM ParcelEntity p GROUP BY p.route.name")
	 List<Object[]> countParcelsByRoute();



	
}
