package com.celo.annotations_based_wiring.service.impl;

import com.celo.annotations_based_wiring.dao.AuditDAO;
import com.celo.annotations_based_wiring.model.Audit;
import com.celo.annotations_based_wiring.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuditServiceImpl implements AuditService {

    @Autowired
    private AuditDAO dao;

    @Override
    public void save(Audit audit) {
        dao.save(audit);
    }

    @Override
    public Audit get(int id) {
        return dao.get(id);
    }
}
