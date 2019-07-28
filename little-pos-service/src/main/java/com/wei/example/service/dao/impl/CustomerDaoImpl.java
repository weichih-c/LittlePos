/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.service.dao.impl;

import com.wei.example.common.constants.SpringBootConstants;
import com.wei.example.common.to.CustomerTO;
import com.wei.example.common.util.LogMsgUtil;
import com.wei.example.service.dao.intf.AbstractDao;
import com.wei.example.service.dao.intf.CustomerDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository(value = SpringBootConstants.CUSTOMER_DAO)
public class CustomerDaoImpl extends AbstractDao implements CustomerDao {
    @Override
    public CustomerTO findById(long customerId) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findById", "start"));
        if (customerId != 0) {
            logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findById", "finish"));
            return entityManager.find(CustomerTO.class, customerId);
        } else {
            logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findById", "finish"));
            return null;
        }
    }

    @Override
    public List<CustomerTO> findAllCustomers() {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findAllCustomers", "start"));
        long startTime = System.currentTimeMillis();
        List<CustomerTO> retList = new ArrayList<>();

        String sql = "SELECT v FROM CustomerTO v ORDER BY v.customerId DESC";
        TypedQuery<CustomerTO> query = entityManager.createQuery(sql, CustomerTO.class);
        List<CustomerTO> resultList = query.getResultList();
        if (resultList != null && !resultList.isEmpty()) {
            retList = resultList;
        } else {
            logger.warn("result list is empty.");
        }

        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findAllCustomers", "finish"));
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findAllCustomers",
                "spend: " + (System.currentTimeMillis() - startTime) + "ms."));
        return retList;
    }

    @Override
    public void insertCustomer(CustomerTO customer) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "insertCustomer", "start"));
        if (customer != null) {
            entityManager.persist(customer);
        }
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "insertCustomer", "finish"));
    }

    @Override
    public void updateCustomer(CustomerTO customer) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "updateCustomer", "start"));
        if (customer != null) {
            entityManager.merge(customer);
        }
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "updateCustomer", "finish"));

    }

    @Override
    public int delCustomerById(long customerId) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "delCustomerById", "start"));
        long startTime = System.currentTimeMillis();

        String sql = "DELETE FROM CustomerTO v WHERE v.customerId = :customerId";
        Query query = entityManager.createQuery(sql);
        query.setParameter("customerId", customerId);
        int delCtr = query.executeUpdate();
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "delCustomerById", "finish"));
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "delCustomerById",
                "spend: " + (System.currentTimeMillis() - startTime) + "ms."));

        return delCtr;
    }
}
