/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.service.dao.impl;

import com.wei.example.common.constants.SpringBootConstants;
import com.wei.example.common.to.StockAddHistTO;
import com.wei.example.common.util.LogMsgUtil;
import com.wei.example.service.dao.intf.AbstractDao;
import com.wei.example.service.dao.intf.StockAddHistDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository(value = SpringBootConstants.STOCK_ADD_HIST_DAO)
public class StockAddHistDaoImpl extends AbstractDao implements StockAddHistDao {

    @Override
    public List<StockAddHistTO> findStockAddHistByProductId(long productId) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findStockAddHistByProductId", "start"));
        long startTime = System.currentTimeMillis();
        List<StockAddHistTO> retList = new ArrayList<>();

        String sql = "SELECT v FROM StockAddHistTO v WHERE v.productId = :productId";
        TypedQuery<StockAddHistTO> query = entityManager.createQuery(sql, StockAddHistTO.class);
        query.setParameter("productId", productId);
        List<StockAddHistTO> resultList = query.getResultList();
        if (resultList != null && resultList.size() > 0) {
            retList = resultList;
        } else {
            logger.warn("result list is empty.");
        }

        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findStockAddHistByProductId", "finish"));
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "findStockAddHistByProductId",
                "spend: " + (System.currentTimeMillis() - startTime) + "ms."));

        return retList;
    }

    @Override
    public void insertStockAddHist(StockAddHistTO stockAddHist) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "insertStockAddHist", "start"));

        if (stockAddHist != null) {
            entityManager.persist(stockAddHist);
        }
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "insertStockAddHist", "finish"));

    }

    @Override
    public int deleteStockAddHistByProductId(long productId) {
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "deleteStockAddHistByProductId", "start"));
        long startTime = System.currentTimeMillis();

        String sql = "DELETE FROM StockAddHistTO v WHERE v.productId = :productId";
        Query query = entityManager.createQuery(sql);
        query.setParameter("productId", productId);
        int delCtr = query.executeUpdate();
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "deleteStockAddHistByProductId", "finish"));
        logger.info(LogMsgUtil.genMethodLogMsg(LOG_CLASS_PREFIX, "deleteStockAddHistByProductId",
                "spend: " + (System.currentTimeMillis() - startTime) + "ms."));

        return delCtr;
    }
}
