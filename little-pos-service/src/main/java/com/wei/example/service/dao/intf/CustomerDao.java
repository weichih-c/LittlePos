/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.service.dao.intf;

import com.wei.example.common.to.CustomerTO;

import java.util.List;

public interface CustomerDao {
    CustomerTO findById(long customerId);

    List<CustomerTO> findAllCustomers();

    void insertCustomer(CustomerTO customer);

    void updateCustomer(CustomerTO customer);

    int delCustomerById(long customerId);
}
