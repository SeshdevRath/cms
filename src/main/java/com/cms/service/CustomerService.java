package com.cms.service;

import com.cms.dao.CustomerDao;
import com.cms.dto.Customer;
import com.cms.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public Customer addCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    public List<Customer> getCustomerList() {
        return customerDao.findAll();
    }

    public Customer getCustomer(int customerId) {

        // return customerDao.findById(customerId).get();

        // Handling exception
        Optional<Customer> optionalCustomer = customerDao.findById(customerId);
        if (!optionalCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer with id " + customerId + " not found");
        }
        
        return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerId, Customer customer) {
        customer.setCustomerId(customerId);
        return customerDao.save(customer);
    }

    public void deleteCustomer(int customerId) {
        customerDao.deleteById(customerId);
    }
}
