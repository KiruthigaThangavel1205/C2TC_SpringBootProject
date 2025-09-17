package com.tnsif.customerservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tnsif.customerservice.entity.Customer;
import com.tnsif.customerservice.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repo;

    public List<Customer> listAll() {
        return repo.findAll();
    }

    public void save(Customer c) {
        repo.save(c);
    }

    public Customer get(Integer cid) {
        return repo.findById(cid).get();
    }

    public void delete(Integer cid) {
        repo.deleteById(cid);
    }

    public void update(Customer c) {
        repo.save(c);
    }
}
