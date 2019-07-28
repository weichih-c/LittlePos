/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.service.dao;

import com.wei.example.common.constants.SpringBootConstants;
import com.wei.example.common.to.StockAddHistTO;
import com.wei.example.service.dao.intf.StockAddHistDao;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StockAddHistDaoTest extends DaoTest {
    private StockAddHistDao dao;

    @Override
    public void setUp() {
        dao = ctx.getBean(SpringBootConstants.STOCK_ADD_HIST_DAO, StockAddHistDao.class);
    }

    @Override
    public void setDown() {
        dao = null;
    }

    @Test
    public void testInsertDelete() {
        long productId = -1L;
        StockAddHistTO stockAddHist = new StockAddHistTO();
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        stockAddHist.setTimeStamp(sdf.format(now));
        stockAddHist.setProductId(productId);
        stockAddHist.setQuantity(1000L);
        stockAddHist.setCreateDate(now);
        stockAddHist.setUpdateDate(now);
        stockAddHist.setCreateUser("TEST_MAN");
        stockAddHist.setUpdateUser("TEST_MAN");
        dao.insertStockAddHist(stockAddHist);

        List<StockAddHistTO> productAddHist = dao.findStockAddHistByProductId(productId);
        Assert.assertFalse(productAddHist.isEmpty());
        logger.debug(productAddHist.get(0).getTimeStamp());

        Assert.assertEquals(1, dao.deleteStockAddHistByProductId(productId));
    }
}
