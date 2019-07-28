/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.service.dao.impl;

import com.wei.example.common.constants.SpringBootConstants;
import com.wei.example.common.to.OrderChangeHistTO;
import com.wei.example.common.util.LogMsgUtil;
import com.wei.example.service.dao.intf.AbstractDao;
import com.wei.example.service.dao.intf.OrderChangeHistDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository(value = SpringBootConstants.ORDER_CHANGE_HIST_DAO)
public class OrderChangeHistDaoImpl extends AbstractDao implements OrderChangeHistDao {

    @Override
    public void insertOrderChangeHist(OrderChangeHistTO orderChangeTO) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "insertOrderChangeHist", "start"));
        if (orderChangeTO != null) {
            entityManager.persist(orderChangeTO);
        }
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "insertOrderChangeHist", "finish"));

    }

    @Override
    public int delOrderChangeHistByOrderId(String orderId) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "delOrderChangeHistByOrderId", "start"));
        long startTime = System.currentTimeMillis();

        String sql = "DELETE FROM OrderChangeHistTO v WHERE v.pk.orderId = :orderId";
        Query query = entityManager.createQuery(sql);
        query.setParameter("orderId", orderId);
        int delCtr = query.executeUpdate();
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "delOrderChangeHistByOrderId", "finish"));
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "delOrderChangeHistByOrderId",
                "spend: " + (System.currentTimeMillis() - startTime) + "ms."));

        return delCtr;
    }
}
