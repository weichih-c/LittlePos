package com.wei.example.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.wei.example.service")
@ImportResource({"classpath*:dataSource-jdbc.xml"})
@PropertySource("classpath:application.properties")
public class ServiceApplication {
}
