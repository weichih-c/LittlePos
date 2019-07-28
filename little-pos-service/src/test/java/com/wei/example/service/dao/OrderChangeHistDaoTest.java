/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.service.dao;

import com.wei.example.common.constants.SpringBootConstants;
import com.wei.example.common.to.OrderChangeHistPK;
import com.wei.example.common.to.OrderChangeHistTO;
import com.wei.example.service.dao.intf.OrderChangeHistDao;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderChangeHistDaoTest extends DaoTest {
    private OrderChangeHistDao dao;

    @Override
    public void setUp() {
        dao = ctx.getBean(SpringBootConstants.ORDER_CHANGE_HIST_DAO, OrderChangeHistDao.class);
    }

    @Override
    public void setDown() {
        dao = null;
    }

    @Test
    public void testInsertDelete() throws ParseException {
        String orderId = "ORDER-00001";

        OrderChangeHistTO changeHist = new OrderChangeHistTO();
        OrderChangeHistPK changeHistPK = new OrderChangeHistPK();
        changeHistPK.setOrderId(orderId);
        changeHistPK.setProductId(1L);
        changeHist.setPk(changeHistPK);
        changeHist.setQuantity(1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        changeHist.setDeliverDate(sdf.parse("2999/12/31"));
        changeHist.setOrderDate(new Date());
        changeHist.setCreateDate(new Date());
        changeHist.setUpdateDate(new Date());
        changeHist.setCreateUser("TEST_MAN");
        changeHist.setUpdateUser("TEST_MAN");
        dao.insertOrderChangeHist(changeHist);

        Assert.assertEquals(1, dao.delOrderChangeHistByOrderId(orderId));
    }
}
