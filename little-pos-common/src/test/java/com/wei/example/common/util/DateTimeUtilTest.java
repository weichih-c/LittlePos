/*
 * Copyright (c) 2019. Weichih-C.
 * All rights reserved.
 */

package com.wei.example.common.util;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtilTest {
    protected Logger logger = LoggerFactory.getLogger(DateTimeUtilTest.class);


    @Test
    public void test() throws ParseException {
        Date now = new Date();
        Date yesterday = DateTimeUtil.getShiftDate(now, -1);
        logger.debug(now.toString());
        logger.debug(yesterday.toString());
        Assert.assertEquals(-1, yesterday.compareTo(now));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date happyNewYear = DateTimeUtil.getShiftDate(sdf.parse("2019/12/25"),7);
        logger.debug(happyNewYear.toString());
        Assert.assertEquals("2020/01/01", sdf.format(happyNewYear));
    }
}
