/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.service.dao;

import com.wei.example.common.constants.SpringBootConstants;
import com.wei.example.common.to.OrderPK;
import com.wei.example.common.to.OrderTO;
import com.wei.example.common.util.DateTimeUtil;
import com.wei.example.service.dao.intf.OrderDao;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderDaoTest extends DaoTest {
    private OrderDao dao;

    @Override
    public void setUp() {
        dao = ctx.getBean(SpringBootConstants.ORDER_DAO, OrderDao.class);
    }

    @Override
    public void setDown() {
        dao = null;
    }

    @Test
    public void testCRUD() throws ParseException {
        String orderId = "TEST-ORDERID-0001";

        OrderPK orderPK = new OrderPK();
        OrderTO order = new OrderTO();
        orderPK.setOrderId(orderId);
        orderPK.setProductId(-1L);
        order.setPk(orderPK);
        order.setQuantity(1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        order.setDeliverDate(sdf.parse("2999/12/31"));
        order.setIsDelivered("N");
        order.setOrderDate(new Date());
        order.setCreateDate(new Date());
        order.setUpdateDate(new Date());
        order.setCreateUser("TEST_MAN");
        order.setUpdateUser("TEST_MAN");

        Assert.assertNull(dao.findByPK(orderPK));
        dao.insertOrder(order); // insert new order
        OrderTO toUpdateOrder = dao.findByPK(orderPK); // check new order
        Assert.assertNotNull(toUpdateOrder);
        Assert.assertEquals(sdf.parse("2999/12/31"), toUpdateOrder.getDeliverDate());
        toUpdateOrder.setDeliverDate(DateTimeUtil.getShiftDate(new Date(), 2));
        toUpdateOrder.setUpdateUser("TEST_MAN");
        toUpdateOrder.setUpdateDate(new Date());
        dao.updateOrder(toUpdateOrder); // update deliver date

        OrderTO updatedOrder = dao.findByPK(orderPK);
        Assert.assertEquals(1, updatedOrder.getDeliverDate().compareTo(new Date()));
        logger.debug(updatedOrder.getUpdateDate().toString());
        logger.debug(updatedOrder.getDeliverDate().toString());
        Assert.assertEquals(1, dao.findByOrderId(orderId).size());
        Assert.assertEquals(1, dao.deleteByOrderId(orderId));
        Assert.assertNull(dao.findByPK(orderPK));
    }
}
