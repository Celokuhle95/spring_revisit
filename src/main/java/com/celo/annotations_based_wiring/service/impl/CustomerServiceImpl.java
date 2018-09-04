package com.celo.annotations_based_wiring.service.impl;

import com.celo.annotations_based_wiring.dao.AuditDAO;
import com.celo.annotations_based_wiring.dao.CustomerDAO;
import com.celo.annotations_based_wiring.model.Audit;
import com.celo.annotations_based_wiring.model.Customer;
import com.celo.annotations_based_wiring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    private AuditDAO auditDAO;

    public void save(Customer customer) {
        customerDAO.save(customer);
        auditDAO.save(new Audit(Customer.class.getName(), "Create")); //invasive code, better done with AOP
    }

    public Customer get(int id) {
        auditDAO.save(new Audit(Customer.class.getName(), "Get")); //invasive code, better done with AOP
        return customerDAO.get(id);
    }
}
