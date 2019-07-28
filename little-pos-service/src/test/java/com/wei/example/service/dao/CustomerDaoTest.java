/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.service.dao;

import com.wei.example.common.constants.SpringBootConstants;
import com.wei.example.common.to.CustomerTO;
import com.wei.example.common.util.DateTimeUtil;
import com.wei.example.service.dao.intf.CustomerDao;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class CustomerDaoTest extends DaoTest {
    private CustomerDao dao;

    @Override
    public void setUp() {
        dao = ctx.getBean(SpringBootConstants.CUSTOMER_DAO, CustomerDao.class);
    }

    @Override
    public void setDown() {
        dao = null;
    }

    @Test
    public void testCRUD() {
        long customerId = -1L;
        Assert.assertNull(dao.findById(customerId));

        CustomerTO customer = new CustomerTO();
        customer.setCustomerId(customerId);
        customer.setAddress("test_addr");
        customer.setContactor("test_contactor");
        customer.setCorpName("test_corpName");
        customer.setDescrpt("test_desc");
        customer.setEmail("test_email");
        customer.setFax("test_fax");
        customer.setPhone("test_phone");
        customer.setLatestOrderTime(DateTimeUtil.getShiftDate(new Date(), -20));
        customer.setCreateDate(new Date());
        customer.setUpdateDate(new Date());
        customer.setCreateUser("TEST_MAN");
        customer.setUpdateUser("TEST_MAN");
        dao.insertCustomer(customer);

        Assert.assertEquals(1, dao.findAllCustomers().size());
        List<CustomerTO> customerList = dao.findAllCustomers();
        Assert.assertEquals(-1, customerList.get(0).getLatestOrderTime().compareTo(customerList.get(0).getCreateDate()));
        logger.debug(customerList.get(0).getLatestOrderTime().toString());
        CustomerTO toUpdateCustomer = dao.findById(customerId);
        toUpdateCustomer.setLatestOrderTime(new Date());
        dao.updateCustomer(toUpdateCustomer);
        customerList = dao.findAllCustomers();
        Assert.assertEquals(1, customerList.get(0).getLatestOrderTime().compareTo(customerList.get(0).getCreateDate()));
        logger.debug(customerList.get(0).getLatestOrderTime().toString());

        Assert.assertEquals(1, dao.delCustomerById(customerId));
    }
}
