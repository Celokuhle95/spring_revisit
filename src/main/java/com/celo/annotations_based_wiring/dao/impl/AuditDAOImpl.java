package com.celo.annotations_based_wiring.dao.impl;

import com.celo.annotations_based_wiring.dao.AuditDAO;
import com.celo.annotations_based_wiring.model.Audit;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AuditDAOImpl extends BaseAbstractDAO<Audit> implements AuditDAO {

    public AuditDAOImpl() {
        super(Audit.class);
    }
}
