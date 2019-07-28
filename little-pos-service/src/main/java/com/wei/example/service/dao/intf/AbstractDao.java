/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.service.dao.intf;

import com.wei.example.common.constants.SpringBootConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional(propagation = Propagation.REQUIRED)
public abstract class AbstractDao {

    protected Logger logger = getLogger();
    protected String LOG_CLASS_PREFIX = " [" + getClass().getSimpleName() + "] ";


    @PersistenceContext(name = SpringBootConstants.pu_datalanding)
    protected EntityManager entityManager;

    private Logger getLogger() {
        return LoggerFactory.getLogger(getClass());
    }
}
