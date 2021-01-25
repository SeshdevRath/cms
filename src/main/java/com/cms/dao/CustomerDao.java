package com.cms.dao;

import com.cms.dto.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {

    @Override
    List<Customer> findAll();
}
