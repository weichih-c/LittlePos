package com.wei.example.web.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wei.example.web.LandingBootTestApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = LandingBootTestApplication.class)
public abstract class AbstractRestTest {
    protected Logger logger = getLogger();

    protected Gson gson = getGson();

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setUp() throws Exception
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        setBeforeMethod();
    }

    @After
    public void tearDown() throws Exception
    {
        setAfterMethod();
    }

    protected abstract void setBeforeMethod();

    protected abstract void setAfterMethod();

    private Logger getLogger()
    {
        return LoggerFactory.getLogger(getClass().getSimpleName());
    }

    private Gson getGson()
    {
        return new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
    }
}
