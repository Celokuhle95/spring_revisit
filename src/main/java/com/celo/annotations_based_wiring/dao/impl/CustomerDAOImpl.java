package com.celo.annotations_based_wiring.dao.impl;

import com.celo.annotations_based_wiring.dao.CustomerDAO;
import com.celo.annotations_based_wiring.dao.impl.BaseAbstractDAO;
import com.celo.annotations_based_wiring.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerDAOImpl extends BaseAbstractDAO<Customer> implements CustomerDAO {

    public CustomerDAOImpl() {
        super(Customer.class);
    }

}
