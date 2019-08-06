package com.wei.example.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@SpringBootApplication
@ImportResource({"classpath*:dataSource-jdbc.xml"})
//@PropertySource("classpath:application.properties")
public class LandingBootTestApplication {
}
