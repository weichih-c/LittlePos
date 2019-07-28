/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.service.dao.impl;

import com.wei.example.common.constants.SpringBootConstants;
import com.wei.example.common.to.OrderPK;
import com.wei.example.common.to.OrderTO;
import com.wei.example.common.util.LogMsgUtil;
import com.wei.example.service.dao.intf.AbstractDao;
import com.wei.example.service.dao.intf.OrderDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository(value = SpringBootConstants.ORDER_DAO)
public class OrderDaoImpl extends AbstractDao implements OrderDao {
    @Override
    public List<OrderTO> findByOrderId(String orderId) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findByOrderId", "start"));
        long startTime = System.currentTimeMillis();
        List<OrderTO> retList = new ArrayList<>();

        String sql = "SELECT v FROM OrderTO v WHERE v.pk.orderId = :orderId";
        TypedQuery<OrderTO> query = entityManager.createQuery(sql, OrderTO.class);
        query.setParameter("orderId", orderId);
        List<OrderTO> resultList = query.getResultList();
        if (resultList != null && !resultList.isEmpty()) {
            retList = resultList;
        } else {
            logger.warn("result list is empty.");
        }

        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findByOrderId", "finish"));
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findByOrderId",
                "spend: " + (System.currentTimeMillis() - startTime) + "ms."));
        return retList;
    }

    @Override
    public OrderTO findByPK(OrderPK pk) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findByPK", "start"));
        if (pk != null) {
            logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findByPK", "finish"));
            return entityManager.find(OrderTO.class, pk);
        }
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findByPK", "finish"));
        return null;
    }

    @Override
    public void insertOrder(OrderTO order) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "insertOrder", "start"));

        if (order != null) {
            entityManager.persist(order);
        }
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "insertOrder", "finish"));
    }

    @Override
    public void updateOrder(OrderTO order) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "updateOrder", "start"));
        long startTime = System.currentTimeMillis();

        if (order != null) {
            entityManager.merge(order);
        }
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "updateOrder", "finish"));
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "updateOrder",
                "spend: " + (System.currentTimeMillis() - startTime) + "ms."));
    }

    @Override
    public int deleteByOrderId(String orderId) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "deleteByOrderId", "start"));
        long startTime = System.currentTimeMillis();

        String sql = "DELETE FROM OrderTO v WHERE v.pk.orderId = :orderId";
        Query query = entityManager.createQuery(sql);
        query.setParameter("orderId", orderId);
        int delCtr = query.executeUpdate();
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "deleteByOrderId", "finish"));
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "deleteByOrderId",
                "spend: " + (System.currentTimeMillis() - startTime) + "ms."));

        return delCtr;
    }
}
