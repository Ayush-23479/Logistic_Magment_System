package com.routemasterapi.api.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.routemasterapi.api.entity.customerentity;



@Repository
public interface CustomerRepository extends CrudRepository<customerentity, Integer> {
	@Query(value = "select * from  kishore_customer ", nativeQuery = true)
    Page<customerentity>findAllCustomer(Pageable pageable);
    
   

}
