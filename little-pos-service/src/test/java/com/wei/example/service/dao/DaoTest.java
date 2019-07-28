/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.service.dao;

import com.wei.example.service.ServiceApplication;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class DaoTest {

    protected Logger logger = getLogger();
    protected String LOG_CLASS_PREFIX = " [" + getClass().getSimpleName() + "] ";

    @Autowired
    protected static ConfigurableApplicationContext ctx;

    /**
     * Before all test methods running.
     */
    @BeforeClass
    public static void beforeClass() {
        ctx = new AnnotationConfigApplicationContext(ServiceApplication.class);
    }

    /**
     * After all test methods running.
     */
    @AfterClass
    public static void afterClass() {
        ctx.close();
    }

    /**
     * Before each test method running.
     */
    @Before
    public abstract void setUp();

    /**
     * After each test  method running.
     */
    @After
    public abstract void setDown();

    private Logger getLogger() {
        return LoggerFactory.getLogger(getClass());
    }
}
