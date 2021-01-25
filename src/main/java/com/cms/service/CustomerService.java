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

//    private int customerIdCount = 1;
//    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer(Customer customer) {
//        customer.setCustomerId(customerIdCount);
//        ++customerIdCount;
//        customerList.add(customer);
//
//        return customer;

        return customerDao.save(customer);
    }

    public List<Customer> getCustomerList() {
//        return customerList;
        return customerDao.findAll();
    }

    public Customer getCustomer(int customerId) {
//        return customerList
//                .stream()
//                .filter(customer -> customer.getCustomerId() == customerId)
//                .findFirst()
//                .get();



//        return customerDao.findById(customerId).get();



        // Handling exception
        Optional<Customer> optionalCustomer = customerDao.findById(customerId);
        if (!optionalCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer with id " + customerId + " not found");
        }

        return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerId, Customer customer) {
//        customerList
//                .forEach(customer1 -> {
//                    if (customer1.getCustomerId() == customerId) {
//                        customer1.setCustomerFirstName(customer.getCustomerFirstName());
//                        customer1.setCustomerLastName(customer.getCustomerLastName());
//                        customer1.setCustomerEmail(customer.getCustomerEmail());
//                    }
//                });
//
//        return customerList
//                .stream()
//                .filter(c -> c.getCustomerId() == customerId)
//                .findFirst()
//                .get();
        customer.setCustomerId(customerId);
        return customerDao.save(customer);
    }

    public void deleteCustomer(int customerId) {
//        customerList
//                .forEach(customer -> {
//                    if (customer.getCustomerId() == customerId) {
//                        customerList.remove(customer);
//                    }
//                });
        customerDao.deleteById(customerId);
    }
}
