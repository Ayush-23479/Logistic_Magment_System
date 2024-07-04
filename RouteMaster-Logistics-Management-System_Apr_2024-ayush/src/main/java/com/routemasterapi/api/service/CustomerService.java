package com.routemasterapi.api.service;
import com.routemasterapi.api.entity.customerentity;
import com.routemasterapi.api.entity.customerentity;
import com.routemasterapi.api.model.CustomerIdRequest;
import com.routemasterapi.api.model.CustomerRequestBody; 
import com.routemasterapi.api.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class CustomerService {
	@Autowired
    private CustomerRepository customerRepository;

    public customerentity createCustomer(CustomerRequestBody customerReqBody) {
    	customerentity newCustomer = new customerentity();
        newCustomer.setFirstName(customerReqBody.getFirstName());
        newCustomer.setLastName(customerReqBody.getLastName());
        newCustomer.setPhone(customerReqBody.getPhone());
        newCustomer.setEmail(customerReqBody.getEmail());
        newCustomer.setAddress(customerReqBody.getAddress());
        return customerRepository.save(newCustomer);		 
    }

    public customerentity updateCustomer(CustomerRequestBody customerReqBody) {
    	customerentity updatedCustomer = customerRepository.findById(customerReqBody.getCustomerId()).orElse(null);
        if (updatedCustomer != null) {
            updatedCustomer.setFirstName(customerReqBody.getFirstName());
            updatedCustomer.setLastName(customerReqBody.getLastName());
            updatedCustomer.setPhone(customerReqBody.getPhone());
            updatedCustomer.setEmail(customerReqBody.getEmail());
            updatedCustomer.setAddress(customerReqBody.getAddress());
            return customerRepository.save(updatedCustomer);
        }
        return null; // Or throw an exception indicating customer not found
    }

    public Page<customerentity> listAllCustomersFromDb(int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        return customerRepository.findAllCustomer(pageable);
    }

    public String deleteCustomer(CustomerIdRequest customerIdReq) {
        int customerId = customerIdReq.getCustomerId();
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return "Customer record deleted successfully";
        } else {
            return "Customer record not found";
        }
    }

}
