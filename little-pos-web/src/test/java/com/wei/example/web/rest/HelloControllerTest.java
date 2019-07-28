package com.wei.example.web.rest;

import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    private static Logger logger = LoggerFactory.getLogger(HelloControllerTest.class);

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @BeforeClass
    public void setUpBeforeClass() throws Exception {

    }

    @AfterClass
    public void tearDownAfterClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
        logger.info("[HelloControllerTest base]: " + base);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString() + "/hello",
                String.class);
        assertThat(response.getBody(), equalTo("Greetings from Spring Boot!\n"));
    }
}